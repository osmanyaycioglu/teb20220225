package com.java.feature;


public interface IExecute {

    public static String ss = "osman";
    public String        s  = "0";

    Integer execute(String val1);

    default String defaultMethod(final String str) {
        Integer executeLoc = this.execute(str);
        return "Sonuç : " + executeLoc;
    }

    public static String staticTest() {
        return "static " + IExecute.ss;
    }
}
