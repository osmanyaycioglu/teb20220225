package com.java.feature;


public class HelloRunner {

    public static void main(final String[] args) {
        String prefix = "test";
        IHello engLoc = new HelloTr();
        String greetLoc = engLoc.greet("osman",
                                       "yay");
        System.out.println(greetLoc);

        IHello espLoc = new IHello() {

            @Override
            public String greet(final String nameParam,
                                final String surnameParam) {
                return prefix + " Ola " + nameParam + " " + surnameParam;
            }
        };
        System.out.println(espLoc.greet("ali",
                                        "veli"));
        IHello esp2Loc = (n,
                          s) -> prefix + " Ola " + n + " " + s;

        System.out.println(esp2Loc.greet("ali",
                                         "veli"));

        IHello esp3Loc = (n,
                          s) -> {
            System.out.println("ESP çalışıyor");
            return prefix + " Ola " + n + " " + s;
        };

        System.out.println(esp3Loc.greet("ali",
                                         "veli"));
    }
}
