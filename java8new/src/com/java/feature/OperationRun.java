package com.java.feature;


public class OperationRun {

    public static void main(final String[] args) {
        Integer sonuc = new Operation(1000).apply(z -> z / 10)
                                           .apply(a -> a * 3)
                                           .apply(s -> s - 15)
                                           .apply(f -> (int) Math.sqrt(f))
                                           .getValue();
        System.out.println("Sonuç : " + sonuc);

    }
}
