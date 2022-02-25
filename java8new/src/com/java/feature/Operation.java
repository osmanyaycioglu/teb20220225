package com.java.feature;


public class Operation {

    private Integer value;

    public Operation(final Integer valueParam) {
        super();
        this.value = valueParam;
    }

    public Operation apply(final IOperation operationParam) {
        this.value = operationParam.doIt(this.value);
        return this;
    }

    public Integer getValue() {
        return this.value;
    }


}
