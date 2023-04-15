package cc.nevsky.otus.config;

import cc.nevsky.otus.services.IOService;
import cc.nevsky.otus.services.IOServiceStreams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    IOService ioService() {
        return new IOServiceStreams(System.in, System.out);
    }
}
