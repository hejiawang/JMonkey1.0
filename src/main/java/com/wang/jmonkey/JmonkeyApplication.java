package com.wang.jmonkey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.wang.jmonkey.modules.*.mapper"})
public class JmonkeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmonkeyApplication.class, args);
	}
}
