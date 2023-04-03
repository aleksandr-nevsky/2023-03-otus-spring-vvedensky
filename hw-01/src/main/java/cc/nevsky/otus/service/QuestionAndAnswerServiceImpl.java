package cc.nevsky.otus.service;

import cc.nevsky.otus.dao.QuestionAndAnswerDao;
import cc.nevsky.otus.domain.QuestionAndAnswer;

import java.util.List;

public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    private final QuestionAndAnswerDao dao;

    public QuestionAndAnswerServiceImpl(QuestionAndAnswerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<QuestionAndAnswer> getAll() {
        return dao.getAll();
    }
}
