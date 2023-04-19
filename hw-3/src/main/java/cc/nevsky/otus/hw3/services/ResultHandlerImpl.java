package cc.nevsky.otus.hw3.services;


import cc.nevsky.otus.hw3.config.AppProperties;
import cc.nevsky.otus.hw3.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ResultHandlerImpl implements ResultHandler {

    private final IOService ioService;

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    @Override
    public void printResult(User player, int correctAnswers) {
        String[] arrayForFormatMsg = new String[]{player.getFirstName(),
                player.getLastName(),
                String.valueOf(correctAnswers)};

        String yourResult = messageSource.getMessage("question.result", arrayForFormatMsg, appProperties.getLocale());
        ioService.outputString(yourResult);
    }
}
