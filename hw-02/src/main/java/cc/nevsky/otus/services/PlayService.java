package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.User;

public interface PlayService {
    int playAndGetResult();

    void printResult(User player, int correctAnswers);
}
