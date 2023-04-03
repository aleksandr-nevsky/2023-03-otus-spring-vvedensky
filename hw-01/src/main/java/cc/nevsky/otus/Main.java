package cc.nevsky.otus;

import cc.nevsky.otus.domain.QuestionAndAnswer;
import cc.nevsky.otus.service.QuestionAndAnswerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    private static final int TRY_COUNTER = 3;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionAndAnswerService service = context.getBean(QuestionAndAnswerService.class);

        service.getAll()
                .forEach(element -> System.out.printf("Question = %s; Answer = %s\n", element.getQuestionText(), element.getAnswer()));

        for (int i = 0; i < TRY_COUNTER; i++) {
            Scanner scanner = new Scanner(System.in);
            QuestionAndAnswer question = service.getRandom();
            System.out.println("Calculate " + question.getQuestionText());
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine();

            if (question.getAnswer().equals(userAnswer)) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect.\n");
            }
        }
    }
}