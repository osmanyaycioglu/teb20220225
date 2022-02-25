package com.java.feature.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.feature.standart.lambda.intf.Customer;

public class StreamRun2 {

    public static void main(final String[] args) {
        List<String> strList = Arrays.asList("ali",
                                             "veli",
                                             "osman",
                                             "ayşe",
                                             "fatma",
                                             "ali",
                                             "veli",
                                             "osman",
                                             "mehmet",
                                             "fatma",
                                             "çağla",
                                             "su",
                                             "nehir",
                                             "nil",
                                             "fatma");
        String collect2Loc = strList.stream()
                                    .distinct()
                                    .filter(s -> s.length() > 4)
                                    .collect(Collectors.joining(","));

        System.out.println(collect2Loc);


        Map<String, Customer> collectLoc = strList.stream()
                                                  .distinct()
                                                  .filter(s -> s.length() > 4)
                                                  .map(s -> Customer.newInstance()
                                                                    .setName(s))
                                                  .collect(Collectors.toMap(c -> c.getName(),
                                                                            c -> c));

        Customer reduceLoc = strList.stream()
                                    .distinct()
                                    .filter(s -> s.length() > 4)
                                    .map(s -> Customer.newInstance()
                                                      .setName(s))
                                    .reduce(Customer.newInstance(),
                                            (ct,
                                             cc) -> ct.setName(ct.getName() + "," + cc.getName()));
        System.out.println(reduceLoc);

        Integer totalCharCount = strList.stream()
                                        .distinct()
                                        .filter(s -> s.length() > 4)
                                        .map(s -> Customer.newInstance()
                                                          .setName(s))
                                        .reduce(0,
                                                (i,
                                                 c) -> i
                                                       + c.getName()
                                                          .length(),
                                                (i1,
                                                 i2) -> i1 + i2);
        System.out.println("Char count : " + totalCharCount);
        IntSummaryStatistics summaryStatisticsLoc = strList.stream()
                                                           .distinct()
                                                           .filter(s -> s.length() > 4)
                                                           .map(s -> Customer.newInstance()
                                                                             .setName(s))
                                                           .mapToInt(c -> c.getName()
                                                                           .length())
                                                           .summaryStatistics();
        System.out.println("Char count : " + summaryStatisticsLoc);

    }
}
