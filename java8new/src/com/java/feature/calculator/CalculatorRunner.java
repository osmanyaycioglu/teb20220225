package com.java.feature.calculator;


public class CalculatorRunner {

    public static void main(final String[] args) {
        Calculator calc = new Calculator().add("add",
                                               (i1,
                                                i2) -> i1 + i2)
                                          .add("subs",
                                               (i1,
                                                i2) -> i1 - i2)
                                          .add("mult",
                                               (i1,
                                                i2) -> i1 * i2)
                                          .add("div",
                                               (i1,
                                                i2) -> {
                                                   if (i2 == 0) {
                                                       return 0;
                                                   }
                                                   return i1 / i2;
                                               })
                                          .add("floor",
                                               (i1,
                                                i2) -> Math.floorDiv(i1,
                                                                     i2));
        calc.run();
    }
}
