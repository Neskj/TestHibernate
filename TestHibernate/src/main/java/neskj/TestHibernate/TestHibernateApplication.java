package neskj.TestHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestHibernateApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestHibernateApplication.class, args);
		System.out.println("<<< Hello Hibernate !!! >>>");
	}

}
