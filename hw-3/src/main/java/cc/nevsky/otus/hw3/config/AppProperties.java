package cc.nevsky.otus.hw3.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Slf4j
@ConfigurationProperties(prefix = "application")
public class AppProperties {

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
