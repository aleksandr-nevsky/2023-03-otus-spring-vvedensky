package cc.nevsky.otus.dao;

import cc.nevsky.otus.config.QuestionsProperties;
import cc.nevsky.otus.domain.Question;
import cc.nevsky.otus.exceptions.SadBusinessException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionsDaoCsv implements QuestionsDao {

    private final QuestionsProperties questionsProperties;

    public QuestionsDaoCsv(QuestionsProperties questionsProperties) {
        this.questionsProperties = questionsProperties;
    }

    @Override
    public List<Question> getAll() {
        try {
            List<Question> questionsAndAnswers = new ArrayList<>();
            Resource resource = new ClassPathResource(questionsProperties.getQuestionsCsv());

            String resourceString = resource.getContentAsString(StandardCharsets.UTF_8);
            List<String> lines = List.of(resourceString.split("\n"));

            lines.forEach(line -> {
                String[] split = line.split(",");
                questionsAndAnswers.add(new Question(split[0], split[1]));
            });

            return questionsAndAnswers;
        } catch (Exception e) {
            throw new SadBusinessException(e);
        }
    }
}
