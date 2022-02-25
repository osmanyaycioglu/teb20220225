package com.teb.training.ee.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class HelloConf {

    @Produces
    @Named("hesp")
    public IHello helloEsp() {
        return new HelloDyn("Ola");
    }

    @Produces
    @Named("hjp")
    @RequestScoped
    public IHello helloJp() {
        return new HelloDyn("Mao");
    }

    @Produces
    @Named("hcn")
    @RequestScoped
    public IHello helloCn() {
        return new HelloDyn("Hao");
    }


}
