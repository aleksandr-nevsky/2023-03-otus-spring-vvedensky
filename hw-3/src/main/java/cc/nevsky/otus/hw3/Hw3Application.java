package cc.nevsky.otus.hw3;

import cc.nevsky.otus.hw3.runner.HwRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Hw3Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Hw3Application.class);

        HwRunner hwRunner = context.getBean(HwRunner.class);
        hwRunner.run();
    }

}
