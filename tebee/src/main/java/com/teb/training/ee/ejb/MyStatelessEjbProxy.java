package com.teb.training.ee.ejb;

public class MyStatelessEjbProxy extends MyStatelessEjb {


    public MyStatelessEjbProxy() {
        super();
    }


    @Override
    public Integer mult(final Integer val1) {
        // pool gidip bir tane gerçek obje al
        // MyStatelessEjb myStatelessEjb = pool.get();
        // trans open
        // Integer multLoc = myStatelessEjb.mult(val1);
        // pool a geri koy
        // trans commit
        return null;
    }

}
