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
        String firstName = ioService.readStringWithPrompt("Enter first name:");
        String lastName = ioService.readStringWithPrompt("Enter last name:");

        return new User(firstName, lastName);
    }
}
