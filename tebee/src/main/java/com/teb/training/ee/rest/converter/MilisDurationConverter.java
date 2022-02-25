package com.teb.training.ee.rest.converter;

import javax.ws.rs.ext.ParamConverter;

import com.teb.training.ee.rest.models.MilisDuration;

public class MilisDurationConverter implements ParamConverter<MilisDuration> {

    @Override
    public MilisDuration fromString(final String valueParam) {
        long milis = 0;
        if (valueParam.endsWith("s")) {
            String stringLoc = (String) valueParam.subSequence(0,
                                                               valueParam.length() - 1);
            milis = Long.parseLong(stringLoc) * 1000;
        } else if (valueParam.endsWith("m")) {
            String stringLoc = (String) valueParam.subSequence(0,
                                                               valueParam.length() - 1);
            milis = Long.parseLong(stringLoc) * 1000 * 60;
        }

        MilisDuration durationLoc = new MilisDuration();
        durationLoc.setMilisecond(milis);
        durationLoc.setValue(valueParam);
        return durationLoc;
    }

    @Override
    public String toString(final MilisDuration valueParam) {
        return valueParam.getValue();
    }

    public static void main(final String[] args) {
        MilisDurationConverter converterLoc = new MilisDurationConverter();
        MilisDuration fromStringLoc = converterLoc.fromString("10m");
        System.out.println(fromStringLoc);
    }

}
