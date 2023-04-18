package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayServiceImplTest {

    @Mock
    private QuestionsService questionsService;

    @Mock
    private IOService ioService;

    @Test
    void playAndGetResult() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("1+1", "2"));

        when(questionsService.getQuestionList())
                .thenReturn(questions);

        when(ioService.readStringWithPrompt("\n"))
                .thenReturn("2");

        PlayService playService = new PlayServiceImpl(questionsService, ioService);
        assertEquals(1, playService.playAndGetResult());
    }
}