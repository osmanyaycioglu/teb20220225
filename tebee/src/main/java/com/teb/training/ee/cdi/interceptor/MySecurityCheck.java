package com.teb.training.ee.cdi.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.teb.training.ee.security.UserObj;
import com.teb.training.ee.servlet.MySecurityFilter;

@Interceptor
@CheckRole
public class MySecurityCheck {

    @Inject
    private MySecurityFilter mySecurityFilter;

    @AroundInvoke
    public Object inter(final InvocationContext ic) {
        try {
            ThreadLocal<UserObj> localuserLoc = MySecurityFilter.localUser;
            if (localuserLoc != null) {
                UserObj userObjLoc = localuserLoc.get();
                CheckRole annotationLoc = ic.getMethod()
                                            .getAnnotation(CheckRole.class);
                if (annotationLoc != null) {
                    if (annotationLoc.value()
                                     .equals(userObjLoc.getRole())) {
                        Object proceedLoc = ic.proceed();
                    }
                }
            }
            return null;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
