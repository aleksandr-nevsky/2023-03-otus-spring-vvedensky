package cc.nevsky.otus.service;

import cc.nevsky.otus.dao.QuestionAndAnswerDao;
import cc.nevsky.otus.domain.QuestionAndAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionAndAnswerServiceImplTest {

    private QuestionAndAnswerServiceImpl service;

    @BeforeEach
    void setUp() {
        QuestionAndAnswerDao dao = () -> new QuestionAndAnswer("42", "42");
        service = new QuestionAndAnswerServiceImpl(dao);
    }

    @Test
    void get42() {
        assertEquals("42", service.getRandom().getQuestionText());
        assertEquals("42", service.getRandom().getAnswer());
    }

}