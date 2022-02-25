package com.teb.training.ee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class MyStatefulEjb implements Serializable {

    private int                  counter = 0;

    @EJB
    private MySecondStatelessEjb mySecondStatelessEjb;

    public MyStatefulEjb() {
    }

    @PostConstruct
    public void init() {
        // init one time only
        System.out.println("Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }

    @PrePassivate
    public void passive() {
        System.out.println("Prepassivate");
    }

    @PostActivate
    public void activate() {
        System.out.println("PostActivate");
    }

    @Remove
    public void remove() {
        System.out.println("remove");
    }

    public Integer mult(final Integer val1) {
        this.counter++;
        return val1 * val1;
    }

    public int getCounter() {
        return this.counter;
    }

}
