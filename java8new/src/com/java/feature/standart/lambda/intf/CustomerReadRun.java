package com.java.feature.standart.lambda.intf;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerReadRun {

    // osmanyay,osman,yay,50,200,1
    public static void main(final String[] args) throws Exception {
        Path pathLoc = Paths.get("customers.txt");
        List<String> readAllLinesLoc = Files.readAllLines(pathLoc);
        Map<String, Customer> customerMap = readAllLinesLoc.stream()
                                                           .map(s -> s.split(","))
                                                           .filter(sa -> sa.length == 6)
                                                           .filter(sa -> sa[5].equals("1"))
                                                           .map(sa -> Customer.newInstance()
                                                                              .setUsername(sa[0])
                                                                              .setName(sa[1])
                                                                              .setSurname(sa[2])
                                                                              .setAge(Integer.parseInt(sa[3]))
                                                                              .setHeight(Integer.parseInt(sa[4])))
                                                           .collect(Collectors.toMap(c -> c.getUsername(),
                                                                                     c -> c));

        System.out.println("Bütün Customerlar : " + customerMap.values());
        List<Customer> collect1Loc = customerMap.values()
                                                .stream()
                                                .filter(c -> c.getAge() < 40)
                                                .filter(c -> c.getHeight() > 170)
                                                .collect(Collectors.toList());
        System.out.println("40 yaş altı 170 den uzun : " + collect1Loc);
        List<Customer> collect2Loc = customerMap.values()
                                                .stream()
                                                .filter(c -> c.getAge() > 30)
                                                .filter(c -> c.getHeight() < 180)
                                                .collect(Collectors.toList());
        System.out.println("30 yaş üstü 180 den kısa : " + collect2Loc);

    }
}
