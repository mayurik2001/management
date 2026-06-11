package com.library.management.controller;

import com.library.management.entity.Language;
import com.library.management.service.LanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/languages")
public class LanguageController extends BaseLookupController<Language> {

     public LanguageController(LanguageService service){
         super(service);
     }

     @Override
    protected Language createEntity(){

         return new Language();
     }
}
