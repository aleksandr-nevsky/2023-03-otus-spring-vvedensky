package cc.nevsky.otus.services;

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
    private QuestionsService questionsService;
    @Mock
    private IOService ioService;

    @Test
    void printMethodShouldCallIoService() {
        QuestionsPrinter questionsPrinter = new QuestionsPrinterImpl(ioService, questionsService);
        questionsPrinter.printAllQuestionsAndAnswers();

        verify(ioService, times(1)).outputString(any());
    }

}