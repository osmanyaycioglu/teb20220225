package com.teb.training.ee.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Calculator {

    private int        counter = 0;

    @Inject
    private OperationX operationX;

    public Integer doubleMult(final Integer int1) {
        this.operationX.test("osman");
        this.counter++;
        return int1 * int1;
    }

    public int getCounter() {
        return this.counter;
    }

}
