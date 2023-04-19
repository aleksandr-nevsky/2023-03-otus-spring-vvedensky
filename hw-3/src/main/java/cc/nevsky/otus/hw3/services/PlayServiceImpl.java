package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.config.AppProperties;
import cc.nevsky.otus.hw3.domain.Question;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PlayServiceImpl implements PlayService {
    private final QuestionsService questionsService;

    private final IOService ioService;

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    @Override
    public int playAndGetResult() {
        List<Question> questionList = questionsService.getQuestionList();
        int correctAnswers = 0;

        for (Question question : questionList) {
            String questionText = question.getQuestionText();
            String message = messageSource.getMessage("question.request.answer",
                    new String[]{questionText},
                    appProperties.getLocale());
            String userAnswer = ioService.readStringWithPrompt(message);
            if (question.getAnswer().equals(userAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }
}
