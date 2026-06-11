package com.library.management.service.Impl;

import com.library.management.entity.Language;
import com.library.management.repo.LanguageRepository;
import com.library.management.service.LanguageService;
import org.springframework.stereotype.Service;


@Service
public class LanguageServiceImpl extends BaseLookupServiceImpl<Language>
      implements LanguageService {

    public LanguageServiceImpl(LanguageRepository repository) {
        super(repository);
    }

}






