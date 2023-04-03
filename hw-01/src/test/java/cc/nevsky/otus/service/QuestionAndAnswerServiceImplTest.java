package cc.nevsky.otus.service;

import cc.nevsky.otus.dao.QuestionAndAnswerDao;
import cc.nevsky.otus.domain.QuestionAndAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionAndAnswerServiceImplTest {

    private QuestionAndAnswerServiceImpl service;

    @BeforeEach
    void setUp() {
        QuestionAndAnswerDao dao = new QuestionAndAnswerDao() {
            @Override
            public List<QuestionAndAnswer> getAll() {
                List<QuestionAndAnswer> test42 = new ArrayList<>();
                test42.add(new QuestionAndAnswer("42", "42"));
                return test42;
            }
        };
        service = new QuestionAndAnswerServiceImpl(dao);
    }

    @Test
    void get42() {
        assertEquals("Question = 42; Answer = 42", service.getAllQuestionsAndAnswers());
    }

}