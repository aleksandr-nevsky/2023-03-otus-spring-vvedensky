package cc.nevsky.otus.runner;

import cc.nevsky.otus.services.QuestionAndAnswerService;

public class HwRunner {

    private final QuestionAndAnswerService questionAndAnswerService;

    public HwRunner(QuestionAndAnswerService questionAndAnswerService) {
        this.questionAndAnswerService = questionAndAnswerService;
    }

    public void run() {
        questionAndAnswerService.printAllQuestionsAndAnswers();
    }

}
