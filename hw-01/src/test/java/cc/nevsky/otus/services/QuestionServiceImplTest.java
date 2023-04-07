package cc.nevsky.otus.services;

import cc.nevsky.otus.dao.QuestionAndAnswerDaoCsv;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionAndAnswerDaoCsv questionAndAnswerDaoCsv;
    @Mock
    private IOService ioService;

    @Test
    void printMethodShouldCallIoService() {
        QuestionAndAnswerServiceImpl answerService = new QuestionAndAnswerServiceImpl(questionAndAnswerDaoCsv, ioService);
        answerService.printAllQuestionsAndAnswers();

        verify(ioService, times(1)).outputString(any());
    }

}