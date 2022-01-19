package com.genius.interview.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PersonConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person() {
        Person person = new Person();
        person.setName("gary");
        return person;
    }

}
