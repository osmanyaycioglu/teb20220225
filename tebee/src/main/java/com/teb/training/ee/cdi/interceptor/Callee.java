package com.teb.training.ee.cdi.interceptor;


public class Callee {

    //@DeltaLog
    public String greet(final String str,
                        final Integer val1) {
        return "Greetings " + str + " " + val1;
    }

}
