package cc.nevsky.otus.hw3.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvProperties {

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    public CsvProperties(MessageSource messageSource, AppProperties appProperties) {
        this.messageSource = messageSource;
        this.appProperties = appProperties;
    }

    public String getQuestionsCsv() {
        return messageSource.getMessage("question.file", new String[]{}, appProperties.getLocale());
    }
}
