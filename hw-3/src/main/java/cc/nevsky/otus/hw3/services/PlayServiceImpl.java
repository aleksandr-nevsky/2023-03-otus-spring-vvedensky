package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.domain.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PlayServiceImpl implements PlayService {
    private final QuestionsService questionsService;

    private final IOService ioService;

    private final LocalisationService localisationService;

    @Override
    public int playAndGetResult() {
        List<Question> questionList = questionsService.getQuestionList();
        int correctAnswers = 0;

        for (Question question : questionList) {
            String questionText = question.getQuestionText();
            String message = localisationService.getMessage("question.request.answer",
                    new String[]{questionText});
            String userAnswer = ioService.readStringWithPrompt(message);
            if (question.getAnswer().equals(userAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }
}
