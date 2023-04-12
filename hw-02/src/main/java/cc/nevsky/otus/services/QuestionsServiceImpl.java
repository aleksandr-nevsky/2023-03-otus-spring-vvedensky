package cc.nevsky.otus.services;

import cc.nevsky.otus.dao.QuestionsDao;
import cc.nevsky.otus.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDao dao;

    public QuestionsServiceImpl(QuestionsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getQuestionList() {
        return Collections.unmodifiableList(dao.getAll());
    }
}
