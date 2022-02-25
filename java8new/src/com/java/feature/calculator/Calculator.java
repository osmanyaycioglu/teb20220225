package com.java.feature.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Calculator {

    private final Map<String, ICalculate> calculatorMap = new HashMap<>();


    public Calculator() {

    }

    public Calculator add(final String name,
                          final ICalculate calculateParam) {
        this.addOperation(name,
                          calculateParam);
        return this;
    }

    private void addOperation(final String name,
                              final ICalculate calculateParam) {
        this.calculatorMap.put(name,
                               calculateParam);
    }

    public void run() {
        try (Scanner scannerLoc = new Scanner(System.in)) {
            while (true) {
                Set<String> keySetLoc = this.calculatorMap.keySet();
                System.out.println("Operations");
                for (String stringLoc : keySetLoc) {
                    System.out.println(stringLoc);
                }
                System.out.println("Yap istediğiniz operasyon : ");
                String nextLineLoc = scannerLoc.nextLine();
                ICalculate iCalculateLoc = this.calculatorMap.get(nextLineLoc);
                if (iCalculateLoc != null) {
                    System.out.println("Val1 : ");
                    int int1 = scannerLoc.nextInt();
                    System.out.println("Val2 : ");
                    int int2 = scannerLoc.nextInt();
                    Integer calculateLoc = iCalculateLoc.calculate(int1,
                                                                   int2);
                    System.out.println("Sonuç : " + calculateLoc);
                    System.out.println("------------------------0---------------------------");
                    System.out.println("");

                }
            }
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }

}
