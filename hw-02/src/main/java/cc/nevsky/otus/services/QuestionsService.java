package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.Question;

import java.util.List;

public interface QuestionsService {

    String getAllQuestionsAndAnswers();

    List<Question> getQuestionAndAnswersList();
}
