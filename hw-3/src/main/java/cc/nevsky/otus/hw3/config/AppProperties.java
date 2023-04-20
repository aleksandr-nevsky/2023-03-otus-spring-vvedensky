package cc.nevsky.otus.hw3.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Slf4j
@Setter
@ConfigurationProperties(prefix = "application")
public class AppProperties {

    private Locale locale;

    private String questionsFileName;

    private String questionsExtension;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getQuestionsCsv() {
        return String.format("%s_%s.%s", questionsFileName, locale, questionsExtension);
    }
}
