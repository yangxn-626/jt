package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
ss
@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringBootRun {
	xz
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRun.class, args);
	}
}
wqe
