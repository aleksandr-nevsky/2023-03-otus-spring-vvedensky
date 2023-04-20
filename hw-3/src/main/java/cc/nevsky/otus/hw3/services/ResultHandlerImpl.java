package cc.nevsky.otus.hw3.services;


import cc.nevsky.otus.hw3.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ResultHandlerImpl implements ResultHandler {

    private final IOService ioService;

    private final LocalisationService localisationService;


    @Override
    public void printResult(User player, int correctAnswers) {
        String[] arrayForFormatMsg = new String[]{player.getFirstName(),
                player.getLastName(),
                String.valueOf(correctAnswers)};

        String yourResult = localisationService.getMessage("question.result", arrayForFormatMsg);
        ioService.outputString(yourResult);
    }
}
