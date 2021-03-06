package sokrisztian.todo.admin;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/avatars/**")
                .addResourceLocations("file:///" + System.getProperty("user.dir") + "/avatars/");
    }

    @Bean
    public DigestUtils digestUtils() {
        return new DigestUtils(SHA3_256);
    }

}
