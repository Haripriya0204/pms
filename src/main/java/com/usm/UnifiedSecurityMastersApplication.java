package com.usm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class})
public class UnifiedSecurityMastersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedSecurityMastersApplication.class, args);
	}

}
