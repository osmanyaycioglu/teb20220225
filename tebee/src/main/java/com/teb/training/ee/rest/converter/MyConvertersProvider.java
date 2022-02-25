package com.teb.training.ee.rest.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

import com.teb.training.ee.rest.models.MilisDuration;

// @Provider
public class MyConvertersProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawTypeParam,
                                              final Type genericTypeParam,
                                              final Annotation[] annotationsParam) {
        if (rawTypeParam.equals(MilisDuration.class)) {
            return (ParamConverter<T>) new MilisDurationConverter();
        }
        return null;
    }

}
