package com.teb.training.ee.cdi.interceptor;

import javax.inject.Inject;

public class Caller {

    int            counter = 0;
    @Inject
    private Callee callee;

    // @DeltaLog
    public String greet(final String str) {
        this.counter++;
        return this.callee.greet(str,
                                 this.counter);

    }


}
