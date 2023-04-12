package cc.nevsky.otus.runner;

import cc.nevsky.otus.domain.User;
import cc.nevsky.otus.services.PlayService;
import cc.nevsky.otus.services.ResultHandler;
import cc.nevsky.otus.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class HwRunner {

    private final UserService userService;

    private final PlayService playService;

    private final ResultHandler resultHandler;

    public HwRunner(UserService userService, PlayService playService, ResultHandler resultHandler) {
        this.userService = userService;
        this.playService = playService;
        this.resultHandler = resultHandler;
    }

    public void run() {
        User user = userService.registerNewUser();
        int gameResult = playService.playAndGetResult();

        resultHandler.printResult(user, gameResult);
    }
}
