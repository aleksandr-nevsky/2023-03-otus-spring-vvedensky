package cc.nevsky.otus.domain;

public class QuestionAndAnswer {
    private final String questionText;

    private final String answer;

    public QuestionAndAnswer(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }
}
