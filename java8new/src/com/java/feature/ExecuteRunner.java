package com.java.feature;


public class ExecuteRunner {

    public static void main(final String[] args) {
        IExecute executeLoc = a -> Integer.parseInt(a);
        String defaultMethodLoc = executeLoc.defaultMethod("10");

        IExecute executeLoc2 = a -> {
            return Integer.parseInt(a);
        };

        IProcess iProcessLoc = () -> "Test strtingi";
        IExecute exec2 = ExecuteRunner::xyz;
        ExecuteRunner er = new ExecuteRunner();
        IExecute exec3 = er::jkl;
        System.out.println("Sonuç : " + exec3.execute("112"));

        doSomething(b -> Integer.parseInt(b) * 10);
        doSomething(b -> Integer.parseInt(b) / 10);
        doSomething(b -> (int) Math.sqrt(Integer.parseInt(b)));
    }

    public static Integer xyz(final String str) {
        return Integer.parseInt(str);
    }

    public static Long abc(final String str) {
        return Long.parseLong(str);
    }

    public Integer jkl(final String str) {
        System.out.println("Method : jkl");
        return Integer.parseInt(str);
    }

    public static void doSomething(final IExecute exec) {
        System.out.println("Something");
        Integer executeLoc = exec.execute("90");
        System.out.println("Sonuç execloc : " + executeLoc);

    }

}
