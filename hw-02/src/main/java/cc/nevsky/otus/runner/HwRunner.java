package cc.nevsky.otus.runner;

import cc.nevsky.otus.services.QuestionsPrinter;

public class HwRunner {

    private final QuestionsPrinter questionsPrinter;

    public HwRunner(QuestionsPrinter questionsPrinter) {
        this.questionsPrinter = questionsPrinter;
    }

    public void run() {
        questionsPrinter.printAllQuestionsAndAnswers();
    }

}
