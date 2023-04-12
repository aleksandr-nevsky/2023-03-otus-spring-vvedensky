package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.User;
import org.springframework.stereotype.Component;

@Component
public class ResultHandlerImpl implements ResultHandler {

    private final IOService ioService;

    public ResultHandlerImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void printResult(User player, int correctAnswers) {
        String finalString = String.format("%s %s, your result = %s",
                player.getFirstName(), player.getLastName(), correctAnswers);
        ioService.outputString(finalString);
    }
}
