package sokrisztian.todo.admin;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;

@Configuration
public class DigestUtilsConfig {

    @Bean
    public DigestUtils digestUtils() {
        return new DigestUtils(SHA3_256);
    }

}
