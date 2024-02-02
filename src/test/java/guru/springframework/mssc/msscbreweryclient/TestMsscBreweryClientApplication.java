package guru.springframework.mssc.msscbreweryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMsscBreweryClientApplication {

	public static void main(String[] args) {
		SpringApplication.from(MsscBreweryClientApplication::main).with(TestMsscBreweryClientApplication.class).run(args);
	}

}
