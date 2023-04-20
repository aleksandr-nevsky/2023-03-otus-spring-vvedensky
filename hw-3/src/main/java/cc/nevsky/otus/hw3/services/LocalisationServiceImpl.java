package cc.nevsky.otus.hw3.services;

import cc.nevsky.otus.hw3.config.AppProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LocalisationServiceImpl implements LocalisationService {

    private final MessageSource messageSource;

    private final AppProperties appProperties;

    public LocalisationServiceImpl(MessageSource messageSource, AppProperties appProperties) {
        this.messageSource = messageSource;
        this.appProperties = appProperties;
    }

    @Override
    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, appProperties.getLocale());
    }
}
