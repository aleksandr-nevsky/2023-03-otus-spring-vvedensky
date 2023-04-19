package cc.nevsky.otus.hw3.dao;


import cc.nevsky.otus.hw3.domain.Question;

import java.util.List;

public interface QuestionsDao {
    List<Question> getAll();

}
