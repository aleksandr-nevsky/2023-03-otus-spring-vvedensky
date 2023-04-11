package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.Question;
import cc.nevsky.otus.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayServiceImpl implements PlayService {
    private final QuestionsService questionsService;

    private final IOService ioService;

    private int correctAnswers = 0;

    public PlayServiceImpl(QuestionsService questionsService, IOService ioService) {
        this.questionsService = questionsService;
        this.ioService = ioService;
    }

    @Override
    public int playAndGetResult() {
        List<Question> questionList = questionsService.getQuestionAndAnswersList();

        for (Question question : questionList) {
            ioService.outputString("Enter answer for question: ");
            ioService.outputString(question.getQuestionText());
            String userAnswer = ioService.readStringWithPrompt("\n");
            if (question.getAnswer().equals(userAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    @Override
    public void printResult(User player, int correctAnswers) {
        String finalString = String.format("%s %s, your result = %s",
                player.getFirstName(), player.getLastName(), correctAnswers);
        ioService.outputString(finalString);
    }
}
