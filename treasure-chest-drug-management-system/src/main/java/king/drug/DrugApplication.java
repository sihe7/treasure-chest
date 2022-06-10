package king.drug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages="king.drug.common.filter")
@SpringBootApplication
public class DrugApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class, args);
    }

}
