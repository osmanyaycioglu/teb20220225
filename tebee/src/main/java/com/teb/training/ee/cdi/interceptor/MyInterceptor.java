package com.teb.training.ee.cdi.interceptor;

import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@DeltaLog
public class MyInterceptor {

    @AroundInvoke
    public Object inter(final InvocationContext ic) {
        try {
            Method methodLoc = ic.getMethod();
            Object targetLoc = ic.getTarget();
            long delta = System.nanoTime();
            Object proceedLoc = ic.proceed();
            System.out.println(targetLoc.toString()
                               + " "
                               + methodLoc.getName()
                               + " Delta : "
                               + (System.nanoTime() - delta));
            return proceedLoc;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

    public Object inter2(final InvocationContext ic) {
        try {
            Method methodLoc = ic.getMethod();
            System.out.println("Before Callee : " + methodLoc.getName());
            Object[] parametersLoc = ic.getParameters();
            String name = (String) parametersLoc[0];
            if ("osman".equals(name)) {
                return "Methodu çağırmaya gerek yok";
            }
            if ("ali".equals(name)) {
                Object[] myParams = new Object[2];
                myParams[0] = "ali giremez";
                myParams[1] = 9328902;
                ic.setParameters(myParams);
                return ic.proceed();
            }
            Object returnObjectLoc = ic.proceed();
            if (returnObjectLoc instanceof String) {
                String str = (String) returnObjectLoc;
                return str + " intercepted";
            }
            System.out.println("After Callee : " + returnObjectLoc);
            return returnObjectLoc;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
