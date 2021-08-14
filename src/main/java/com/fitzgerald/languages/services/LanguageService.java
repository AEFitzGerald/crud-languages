package com.fitzgerald.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitzgerald.languages.models.Language;
import com.fitzgerald.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	
	//-- tell the service about the repository ---- add the language repository as a dependency
    private final LanguageRepository languageRepository;
    
    //-- constructor for the service
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
  
    public List<Language> allLanguages() {
        return (List<Language>) this.languageRepository.findAll();
    }
    
    public Language createLanguage(Language lang) {
        return this.languageRepository.save(lang);
    }
    
    public Language findLanguage(Long id) {
    	return this.languageRepository.findById(id).orElse(null);
  
    }
    
    public void deleteLanguage(Long id) {
    		this.languageRepository.deleteById(id);
    }

    public Language updateLanguage(Language lang) {
    		return this.languageRepository.save(lang);		
    }
    
    public Language updateLanguageAnothaOne(Long id, String languageName, String creator, double version) {
  
    		Language lang = this.findLanguage(id);
    		System.out.println("***********");
    		System.out.println(lang.getLanguageName());
    		System.out.println("***********");
    		
    		//update that object
    		System.out.println(languageName);
    		lang.setLanguageName(languageName);
    		lang.setCreator(creator);
    		lang.setVersion(version);
    		
    		return this.languageRepository.save(lang);
    }

}
