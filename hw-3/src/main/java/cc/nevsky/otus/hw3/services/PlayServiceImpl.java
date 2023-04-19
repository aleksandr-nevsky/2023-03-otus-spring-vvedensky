package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.domain.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayServiceImpl implements PlayService {
    private final QuestionsService questionsService;

    private final IOService ioService;

    public PlayServiceImpl(QuestionsService questionsService, IOService ioService) {
        this.questionsService = questionsService;
        this.ioService = ioService;
    }

    @Override
    public int playAndGetResult() {
        List<Question> questionList = questionsService.getQuestionList();
        int correctAnswers = 0;

        for (Question question : questionList) {
            String message = "Enter answer for question: " + question.getQuestionText();
            String userAnswer = ioService.readStringWithPrompt(message);
            if (question.getAnswer().equals(userAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }
}
