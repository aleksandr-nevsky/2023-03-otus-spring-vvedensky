package cc.nevsky.otus.services;

import cc.nevsky.otus.dao.QuestionsDao;

import java.util.stream.Collectors;

public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDao dao;


    public QuestionsServiceImpl(QuestionsDao dao) {
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
