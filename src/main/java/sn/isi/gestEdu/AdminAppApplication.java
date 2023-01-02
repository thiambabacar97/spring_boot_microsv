package sn.isi.gestEdu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableHystrix
@ComponentScan(basePackages = "sn.isi.gestEdu")
@Configuration
@EnableAutoConfiguration
public class AdminAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAppApplication.class, args);
	}

}
