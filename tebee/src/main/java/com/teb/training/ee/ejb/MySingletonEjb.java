package com.teb.training.ee.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class MySingletonEjb {

    private int                       counter  = 0;
    private final Map<String, String> strMap   = new HashMap<>();
    private final Map<String, String> strMapTS = new ConcurrentHashMap<>();
    private final List<String>        list     = new ArrayList<>();
    private final List<String>        listTS   = new Vector<>();
    private final List<String>        listTS2  = Collections.synchronizedList(new ArrayList<>());

    public MySingletonEjb() {
    }

    @Lock(LockType.WRITE)
    public Integer mult(final Integer val1) {
        this.counter++;
        return val1 * val1;
    }

    @Lock(LockType.READ)
    public int getCounter() {
        return this.counter;
    }

}
