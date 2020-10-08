package bashpound.marketplace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "bashpound.marketplace.infra.repository")
public class Martketplace2Application {

	public static void main(String[] args) {
		SpringApplication.run(Martketplace2Application.class, args);
	}

}
