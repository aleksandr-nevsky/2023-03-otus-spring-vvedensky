package cc.nevsky.otus;

import cc.nevsky.otus.service.QuestionAndAnswerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionAndAnswerService service = context.getBean(QuestionAndAnswerService.class);

        service.getAll().forEach(element ->
                System.out.printf("Question = %s; Answer = %s\n", element.getQuestionText(), element.getAnswer()));
    }
}