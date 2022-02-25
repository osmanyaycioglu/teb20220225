package com.teb.training.ee.rest.models;


public class MilisDuration {

    private String value;
    private long   milisecond;

    public String getValue() {
        return this.value;
    }

    public void setValue(final String valueParam) {
        this.value = valueParam;
    }

    public long getMilisecond() {
        return this.milisecond;
    }

    public void setMilisecond(final long milisecondParam) {
        this.milisecond = milisecondParam;
    }

    @Override
    public String toString() {
        return "MilisDuration [value=" + this.value + ", milisecond=" + this.milisecond + "]";
    }


}
