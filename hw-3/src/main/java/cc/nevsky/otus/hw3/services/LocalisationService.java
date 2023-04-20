package cc.nevsky.otus.hw3.services;

import org.springframework.lang.Nullable;

public interface LocalisationService {

    String getMessage(String code, @Nullable Object[] args);

}
