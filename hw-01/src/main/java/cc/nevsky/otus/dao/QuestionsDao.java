package cc.nevsky.otus.dao;

import cc.nevsky.otus.domain.Question;

import java.util.List;

public interface QuestionsDao {
    List<Question> getAll();

}
