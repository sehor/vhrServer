package hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class VhrServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrServerApplication.class, args);
	}

}
