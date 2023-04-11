package cc.nevsky.otus.runner;

import cc.nevsky.otus.domain.User;
import cc.nevsky.otus.services.PlayService;
import cc.nevsky.otus.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class HwRunner {

    private final UserService userService;

    private final PlayService playService;

    public HwRunner(UserService userService, PlayService playService) {
        this.userService = userService;
        this.playService = playService;
    }

    public void run() {
        User user = userService.registerNewUser();
        int gameResult = playService.playAndGetResult();

        playService.printResult(user, gameResult);
    }

}
