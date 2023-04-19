package cc.nevsky.otus.hw3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class QuestionsProperties {

    @Value("${question.file}")
    private String questionsCsv;

    public String getQuestionsCsv() {
        return questionsCsv;
    }
}
