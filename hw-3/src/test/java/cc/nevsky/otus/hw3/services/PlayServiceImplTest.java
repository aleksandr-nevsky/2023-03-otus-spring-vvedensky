package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.domain.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayServiceImplTest {

    @Mock
    private QuestionsService questionsService;

    @Mock
    private IOService ioService;

    @Mock
    private LocalisationService localisationService;

    @Test
    void playAndGetResult() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("1+1", "2"));

        when(questionsService.getQuestionList())
                .thenReturn(questions);

        when(ioService.readStringWithPrompt("\n"))
                .thenReturn("2");

        when(localisationService.getMessage(anyString(), any()))
                .thenReturn("\n");

        PlayService playService = new PlayServiceImpl(questionsService, ioService, localisationService);
        assertEquals(1, playService.playAndGetResult());
    }
}