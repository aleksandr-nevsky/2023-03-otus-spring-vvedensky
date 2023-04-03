package cc.nevsky.otus.service;

import cc.nevsky.otus.domain.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerService {
    QuestionAndAnswer getRandom();

    List<QuestionAndAnswer> getAll();
}
