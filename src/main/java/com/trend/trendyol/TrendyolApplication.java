package com.trend.trendyol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@ComponentScan(basePackages = "com.trend.trendyol")
@SpringBootApplication
public class TrendyolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendyolApplication.class, args);
	}

}
