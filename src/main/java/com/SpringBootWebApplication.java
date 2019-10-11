package com;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.bean.Role;
import com.spring.dao.RoleDao;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
    public CommandLineRunner demoData(RoleDao roleDao) {
        return args -> { 
			
        	List<Role> roles = roleDao.getRole();
			
			if (roles.isEmpty()) {
				
				Role roleStandardUser = new Role();
				roleStandardUser.setId(1L);
				roleStandardUser.setName("STANDARD_USER");

				roleDao.addRole(roleStandardUser);

				Role roleAdmin = new Role();
				roleStandardUser.setId(2L);
				roleAdmin.setName("ADMIN");

				roleDao.addRole(roleAdmin);
			}
        };
    }
}