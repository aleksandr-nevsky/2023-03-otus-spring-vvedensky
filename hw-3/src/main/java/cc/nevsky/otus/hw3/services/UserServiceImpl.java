package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.config.AppProperties;
import cc.nevsky.otus.hw3.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    public UserServiceImpl(IOService ioService, MessageSource messageSource, AppProperties appProperties) {
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.appProperties = appProperties;
    }

    @Override
    public User registerNewUser() {
        String askFirstName = messageSource.getMessage("question.request.first_name",
                new String[]{},
                appProperties.getLocale());
        String askLastName = messageSource.getMessage("question.request.last_name",
                new String[]{},
                appProperties.getLocale());

        String firstName = ioService.readStringWithPrompt(askFirstName);
        String lastName = ioService.readStringWithPrompt(askLastName);

        return new User(firstName, lastName);
    }
}
