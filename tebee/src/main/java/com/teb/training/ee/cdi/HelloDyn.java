package com.teb.training.ee.cdi;


public class HelloDyn implements IHello {

    private final String prefix;

    public HelloDyn(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }

    @Override
    public String hello(final String nameParam,
                        final String surnameParam) {
        return this.prefix + " " + nameParam + " " + surnameParam;
    }


}
