package cc.nevsky.otus.services;

import org.springframework.stereotype.Service;

@Service
public class QuestionsPrinterImpl implements QuestionsPrinter {

    private final IOService ioService;

    private final QuestionsService questionsService;

    public QuestionsPrinterImpl(IOService ioService, QuestionsService questionsService) {
        this.ioService = ioService;
        this.questionsService = questionsService;
    }

    @Override
    public void printAllQuestionsAndAnswers() {
        ioService.outputString(questionsService.getAllQuestionsAndAnswers());
    }
}
