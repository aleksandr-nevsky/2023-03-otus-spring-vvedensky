package cc.nevsky.otus.hw3.services;


import cc.nevsky.otus.hw3.domain.Question;

import java.util.List;

public interface QuestionsService {

    List<Question> getQuestionList();
}
