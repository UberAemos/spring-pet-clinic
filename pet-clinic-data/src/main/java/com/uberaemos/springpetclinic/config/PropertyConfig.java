package com.uberaemos.springpetclinic.config;

import com.uberaemos.springpetclinic.PetClinicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:data-source-one.properties"),
        @PropertySource("classpath:data-source-two.properties")
})
public class PropertyConfig {

    @Value("${data.username}")
    private String username;

    @Value("${data.password}")
    private String password;

    @Value("${data.url}")
    private String url;

    @Bean
    public PetClinicDataSource petClinicDataSource() {
        PetClinicDataSource petClinicDataSource = new PetClinicDataSource();
        petClinicDataSource.setUsername(username);
        petClinicDataSource.setPassword(password);
        petClinicDataSource.setUrl(url);
        return petClinicDataSource;

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
