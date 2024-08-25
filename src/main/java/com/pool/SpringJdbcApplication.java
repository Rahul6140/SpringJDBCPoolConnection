package com.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class SpringJdbcApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started");
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("Select * from public.\"Student\"");

		maps.forEach(items ->{
			System.out.println("Id : "+items.get("ID"));
			System.out.println("Name : "+items.get("Name"));
			System.out.println("Age : "+items.get("Age"));
			System.out.println("---------------------------------");
		});


	}
}
