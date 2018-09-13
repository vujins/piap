package library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Library {

	public static void main(String[] args) {
		SpringApplication.run(Library.class, args);
	}
}
