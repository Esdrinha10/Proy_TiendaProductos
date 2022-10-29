package Tienda_proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.baeldung.dependency.exception"})
public class TiendaProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaProyectoApplication.class, args);
	}

}
