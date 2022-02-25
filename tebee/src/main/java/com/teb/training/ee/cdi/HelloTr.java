package com.teb.training.ee.cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("htr")
@Alternative
public class HelloTr implements IHello {

    @Override
    public String hello(final String nameParam,
                        final String surnameParam) {
        return "Selam " + nameParam + " " + surnameParam;
    }

}
