package cc.nevsky.otus.dao;

import cc.nevsky.otus.domain.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoCsv implements QuestionsDao {

    private final String csvPath;

    public QuestionsDaoCsv(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<Question> getAll() {
        try {
            List<Question> questionsAndAnswers = new ArrayList<>();
            Resource resource = new ClassPathResource(csvPath);

            String resourceString = resource.getContentAsString(StandardCharsets.UTF_8);
            List<String> lines = List.of(resourceString.split("\n"));

            lines.forEach(line -> {
                String[] split = line.split(",");
                questionsAndAnswers.add(new Question(split[0], split[1]));
            });

            return questionsAndAnswers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
