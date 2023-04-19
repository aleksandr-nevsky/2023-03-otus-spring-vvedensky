package cc.nevsky.otus.hw3.runner;


import cc.nevsky.otus.hw3.domain.User;
import cc.nevsky.otus.hw3.services.PlayService;
import cc.nevsky.otus.hw3.services.ResultHandler;
import cc.nevsky.otus.hw3.services.UserService;
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
