package com.teb.training.ee.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MyStatelessEjb {

    private int                  counter = 0;
    @EJB
    private MySecondStatelessEjb mySecondStatelessEjb;

    public MyStatelessEjb() {
    }

    public Integer mult(final Integer val1) {
        this.counter++;
        return val1 * val1;
    }

    public int getCounter() {
        return counter;
    }

}
