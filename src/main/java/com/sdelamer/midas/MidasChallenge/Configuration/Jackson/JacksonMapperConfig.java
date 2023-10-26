package com.sdelamer.midas.MidasChallenge.Configuration.Jackson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration

public class JacksonMapperConfig {

	 @Bean
	     ObjectMapper objectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	        return objectMapper;
	    }
}
