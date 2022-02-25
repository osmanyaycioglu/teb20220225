package com.java.feature;


public class HelloEng implements IHello {

    @Override
    public String greet(final String nameParam,
                        final String surnameParam) {
        return "Hello " + nameParam + " " + surnameParam;
    }

    public void rtest() {
        System.out.println("test");
    }

}
