package cc.nevsky.otus.hw3.services;


import cc.nevsky.otus.hw3.domain.User;

public interface ResultHandler {

    void printResult(User player, int correctAnswers);
}
