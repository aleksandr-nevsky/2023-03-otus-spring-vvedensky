package cc.nevsky.otus.dao;

import cc.nevsky.otus.domain.QuestionAndAnswer;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionAndAnswerDaoCsv implements QuestionAndAnswerDao {
    private final List<QuestionAndAnswer> questionsAndAnswers;

    private final String csvPath;

    public QuestionAndAnswerDaoCsv(String csvPath) throws IOException {
        this.csvPath = csvPath;
        this.questionsAndAnswers = new ArrayList<>();
        init();
    }

    void init() throws IOException {
        File resource = new ClassPathResource(csvPath).getFile();
        List<String> lines = Files.readAllLines(resource.toPath());

        lines.forEach(line -> {
            String[] split = line.split(",");
            questionsAndAnswers.add(new QuestionAndAnswer(split[0], split[1]));
        });
    }

    @Override
    public QuestionAndAnswer getRandomQuestion() {
        int randomNum = ThreadLocalRandom.current().nextInt(questionsAndAnswers.size());
        return questionsAndAnswers.get(randomNum);
    }

    @Override
    public List<QuestionAndAnswer> getAll() {
        return List.copyOf(questionsAndAnswers);
    }

}
