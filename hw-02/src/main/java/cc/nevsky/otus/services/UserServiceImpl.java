package cc.nevsky.otus.services;

import cc.nevsky.otus.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    public UserServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public User registerNewUser() {
        ioService.outputString("Enter first name:");
        String firstName = ioService.readStringWithPrompt("");

        ioService.outputString("Enter last name:");
        String lastName = ioService.readStringWithPrompt("");

        return new User(firstName, lastName);
    }
}
