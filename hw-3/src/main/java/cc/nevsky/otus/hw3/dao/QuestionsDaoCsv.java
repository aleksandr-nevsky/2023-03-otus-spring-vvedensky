package cc.nevsky.otus.hw3.dao;


import cc.nevsky.otus.hw3.config.AppProperties;
import cc.nevsky.otus.hw3.domain.Question;
import cc.nevsky.otus.hw3.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class QuestionsDaoCsv implements QuestionsDao {

    private final AppProperties appProperties;

    @Override
    public List<Question> getAll() {
        try {
            List<Question> questionsAndAnswers = new ArrayList<>();
            Resource resource = new ClassPathResource(appProperties.getQuestionsCsv());

            String resourceString = resource.getContentAsString(StandardCharsets.UTF_8);
            List<String> lines = List.of(resourceString.split("\n"));

            lines.forEach(line -> {
                String[] split = line.split(",");
                questionsAndAnswers.add(new Question(split[0], split[1]));
            });

            return questionsAndAnswers;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
