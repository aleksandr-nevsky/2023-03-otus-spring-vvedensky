package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.User;

public interface ResultHandler {

    void printResult(User player, int correctAnswers);
}
