package com.teb.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MySecondStatelessEjb {


    public MySecondStatelessEjb() {
    }

    public Integer mult(final Integer val1) {
        return val1 * val1;
    }

}
