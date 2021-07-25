package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanPostProcessorTestApplication {

	public static void main(String[] args) {
		System.out.println("Main method start");
		SpringApplication.run(BeanPostProcessorTestApplication.class, args);
		System.out.println("Main method end");
	}
}
