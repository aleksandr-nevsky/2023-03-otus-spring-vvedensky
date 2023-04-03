package cc.nevsky.otus.dao;

import cc.nevsky.otus.domain.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerDao {
    QuestionAndAnswer getRandomQuestion();

    List<QuestionAndAnswer> getAll();

}
