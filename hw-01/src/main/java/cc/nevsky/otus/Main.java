package cc.nevsky.otus;

import cc.nevsky.otus.runner.HwRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        HwRunner hwRunner = context.getBean(HwRunner.class);
        hwRunner.run();
    }
}