package cc.nevsky.otus.services;

import cc.nevsky.otus.dao.QuestionAndAnswerDao;

import java.util.stream.Collectors;

public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {
    private final QuestionAndAnswerDao dao;

    private final IOService ioService;

    public QuestionAndAnswerServiceImpl(QuestionAndAnswerDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @Override
    public String getAllQuestionsAndAnswers() {
        var rows = dao.getAll();

        return rows.stream()
                .map(element ->
                        String.format("Question = %s; Answer = %s", element.getQuestionText(), element.getAnswer()))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void printAllQuestionsAndAnswers() {
        ioService.outputString(this.getAllQuestionsAndAnswers());
    }
}
