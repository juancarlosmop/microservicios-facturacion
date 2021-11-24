package com.app.factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.app.commons.entity"})
public class ServicioFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioFacturacionApplication.class, args);
	}

}
