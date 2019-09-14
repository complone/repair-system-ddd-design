package com.lizhi.guide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启事务管理
@SpringBootApplication
@MapperScan("com.lizhi.guide.mapper")
public class GuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuideApplication.class, args);
	}
}
