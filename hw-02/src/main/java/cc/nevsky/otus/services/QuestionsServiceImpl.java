package cc.nevsky.otus.services;

import cc.nevsky.otus.dao.QuestionsDao;
import cc.nevsky.otus.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    @Override
    public List<Question> getQuestionAndAnswersList() {
        return Collections.unmodifiableList(dao.getAll());
    }
}
