package com.java.feature.stream;

import java.util.Arrays;
import java.util.List;

public class StreamRun {

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
        //        List<String> collectLoc = strList.stream()
        //                                         .distinct()
        //                                         .sorted()
        //                                         .filter(s -> s.length() > 4)
        //                                         .collect(Collectors.toList());
        //        collectLoc.forEach(System.out::println);

        strList.stream()
               .filter(s -> {
                   System.out.println("Data Filter1 : "
                                      + s
                                      + " Thread : "
                                      + Thread.currentThread()
                                              .getName());
                   return s.length() > 1;
               })
               .distinct()
               .peek(s -> System.out.println("Data peek1 : "
                                             + s
                                             + " Thread : "
                                             + Thread.currentThread()
                                                     .getName()))
               .peek(s -> System.out.println("Data peek2 : "
                                             + s
                                             + " Thread : "
                                             + Thread.currentThread()
                                                     .getName()))
               .filter(s -> {
                   System.out.println("Data Filter2 : "
                                      + s
                                      + " Thread : "
                                      + Thread.currentThread()
                                              .getName());
                   return s.length() > 1;
               })
               .anyMatch(s -> s.contains("e"));

        //        strList.stream()
        //               .filter(s -> {
        //                   System.out.println("Data Filter1 : "
        //                                      + s
        //                                      + " Thread : "
        //                                      + Thread.currentThread()
        //                                              .getName());
        //                   return s.length() > 1;
        //               })
        //               .distinct()
        //               .peek(s -> System.out.println("Data peek1 : "
        //                                             + s
        //                                             + " Thread : "
        //                                             + Thread.currentThread()
        //                                                     .getName()))
        //               .peek(s -> System.out.println("Data peek2 : "
        //                                             + s
        //                                             + " Thread : "
        //                                             + Thread.currentThread()
        //                                                     .getName()))
        //               .filter(s -> {
        //                   System.out.println("Data Filter2 : "
        //                                      + s
        //                                      + " Thread : "
        //                                      + Thread.currentThread()
        //                                              .getName());
        //                   return s.length() > 4;
        //               })
        //               .sorted()
        //               .forEach(s -> {
        //                   System.out.println("Data End : "
        //                                      + s
        //                                      + " Thread : "
        //                                      + Thread.currentThread()
        //                                              .getName());
        //                   System.out.println("-----------");
        //               });
    }
}
