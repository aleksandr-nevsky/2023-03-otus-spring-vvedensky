package cc.nevsky.otus.service;

import cc.nevsky.otus.dao.QuestionAndAnswerDao;

import java.util.stream.Collectors;

public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    private final QuestionAndAnswerDao dao;

    public QuestionAndAnswerServiceImpl(QuestionAndAnswerDao dao) {
        this.dao = dao;
    }

    @Override
    public String getAllQuestionsAndAnswers() {
        var rows = dao.getAll();

        return rows.stream()
                .map(element ->
                        String.format("Question = %s; Answer = %s", element.getQuestionText(), element.getAnswer()))
                .collect(Collectors.joining("\n"));
    }
}
