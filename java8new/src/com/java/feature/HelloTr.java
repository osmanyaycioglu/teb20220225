package com.java.feature;


public class HelloTr implements IHello {

    @Override
    public String greet(final String nameParam,
                        final String surnameParam) {
        return "Selam " + nameParam + " " + surnameParam;
    }


}
