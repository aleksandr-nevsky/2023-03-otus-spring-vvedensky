package cc.nevsky.otus.hw3.config;


import cc.nevsky.otus.hw3.services.IOService;
import cc.nevsky.otus.hw3.services.IOServiceStreams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    IOService ioService() {
        return new IOServiceStreams(System.in, System.out);
    }
}
