package com.second.springcoredemo.config;

import com.second.springcoredemo.common.Coach;
import com.second.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")   //we can give custom bean name or else bean is same as method name in this case its swimCoach
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
