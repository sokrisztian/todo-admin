package sokrisztian.todo.admin;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DigestUtils digestUtils() {
        return new DigestUtils(SHA3_256);
    }

}
