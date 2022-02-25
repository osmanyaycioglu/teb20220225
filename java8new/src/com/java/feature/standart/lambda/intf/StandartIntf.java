package com.java.feature.standart.lambda.intf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class StandartIntf {

    public static void main(final String[] args) {
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        Function<String, String> f2 = s -> "çevrim " + Integer.parseInt(s);
        Function<Customer, String> f3 = c -> "Sevgili " + c.getName() + " " + c.getSurname();
        System.out.println(f3.apply(Customer.newInstance()
                                            .setName("osman")
                                            .setSurname("yay")
                                            .setWeight(95)));
        System.out.println(f3.apply(new Customer().setName("osman")
                                                  .setSurname("yay")
                                                  .setWeight(95)));
        UnaryOperator<Integer> f4 = i -> i * 10;

        BiFunction<Integer, Integer, Integer> biFun1 = (i1,
                                                        i2) -> i1 + i2;
        BinaryOperator<Integer> biFun3 = (i1,
                                          i2) -> i1 + i2;

        BiFunction<String, String, Integer> biFun2 = (s1,
                                                      s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);


        Consumer<Customer> c1 = cus -> System.out.println(cus);
        BiConsumer<String, Integer> c5 = (s,
                                          i) -> System.out.println(s + " : " + i);

        List<Customer> customerList = Arrays.asList(Customer.newInstance()
                                                            .setName("osman")
                                                            .setSurname("yay")
                                                            .setWeight(95),
                                                    Customer.newInstance()
                                                            .setName("ali")
                                                            .setSurname("veli")
                                                            .setWeight(70),
                                                    Customer.newInstance()
                                                            .setName("orhan")
                                                            .setSurname("veli")
                                                            .setWeight(75));
        // Collections.sort(customerList);
        customerList.sort((cu1,
                           cu2) -> cu1.getName()
                                      .compareTo(cu2.getName()));
        Collections.sort(customerList,
                         (cu1,
                          cu2) -> cu1.getName()
                                     .compareTo(cu2.getName()));

        List<String> strList = Arrays.asList("1",
                                             "2",
                                             "3",
                                             "10",
                                             "9");
        Consumer<String> c2 = s -> System.out.println(s);
        strList.forEach(c2);
        System.out.println("---------------------------");
        strList.sort((s1,
                      s2) -> s1.compareTo(s2));
        strList.forEach(c2);

        Predicate<Customer> custP1 = c -> c.getWeight() > 80;
        BiPredicate<Integer, Integer> biPredicateLoc = (i1,
                                                        i2) -> i1 > i2;

        Supplier<String> sup = () -> "test"
                                     + UUID.randomUUID()
                                           .toString();

    }
}
