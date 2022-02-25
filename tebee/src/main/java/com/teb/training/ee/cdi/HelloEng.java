package com.teb.training.ee.cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("heng")
@Alternative
public class HelloEng implements IHello {

    @Override
    public String hello(final String nameParam,
                        final String surnameParam) {
        return "Hello " + nameParam + " " + surnameParam;
    }

}
