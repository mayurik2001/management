package com.library.management.service.Impl;

import com.library.management.entity.Publisher;
import com.library.management.repo.PublisherRepository;
import com.library.management.service.PublisherService;
import org.springframework.stereotype.Service;


@Service
public class PublisherServiceImpl extends BaseLookupServiceImpl<Publisher>
          implements PublisherService {

    public PublisherServiceImpl (PublisherRepository repository)
    {
        super(repository);
    }
}
