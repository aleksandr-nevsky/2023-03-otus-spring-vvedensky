package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    private final LocalisationService localisationService;


    @Override
    public User registerNewUser() {
        String askFirstName = localisationService.getMessage("question.request.first_name",
                new String[]{});
        String askLastName = localisationService.getMessage("question.request.last_name",
                new String[]{});

        String firstName = ioService.readStringWithPrompt(askFirstName);
        String lastName = ioService.readStringWithPrompt(askLastName);

        return new User(firstName, lastName);
    }
}
