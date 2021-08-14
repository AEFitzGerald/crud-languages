package com.fitzgerald.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitzgerald.languages.models.Language;
import com.fitzgerald.languages.services.LanguageService;

@Controller
public class LanguageController {
	
    private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String getAll(Model model, @ModelAttribute("newLang") Language newlang) {
        List<Language> allLang = languageService.allLanguages();
        model.addAttribute("allLang", allLang);
//        another way of creating an empty object for the form data to bind to 
//        Language newLanguage = new Language();
//        model.addAttribute("newLang", newLanguage);
        return "dashboard.jsp";
    }
    
	@PostMapping("/languages/create")
	public String createLanguage(@Valid @ModelAttribute("lang") Language lang, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// if errors data will be lost in the post, so pass the data again for info to stay on page
			List<Language> allLang = languageService.allLanguages();
	        model.addAttribute("allLang", allLang);
			return "dashboard.jsp";
		}else {
			this.languageService.createLanguage(lang);
			return "redirect:/languages";
		}
	}	
	
	@GetMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id")Long id, Model model) {
			Language lang = this.languageService.findLanguage(id);
			model.addAttribute("lang", lang);
			
			return "show.jsp";
		}
	
	 @GetMapping("/languages/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model) {
	        
		 	Language l = this.languageService.findLanguage(id);
	        model.addAttribute("lang", l);
	        
	        return "edit.jsp";
	    }
	    
	 @PostMapping(value="/languages/update/{id}")
	 public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("lang") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            languageService.updateLanguage(language);
	            return "redirect:/languages/{id}";
	        }
	    }
	 
	 @GetMapping("/languages/delete/{id}")
	 public String destroy(@PathVariable("id") Long id) {
		 	this.languageService.deleteLanguage(id);
		 	return "redirect:/languages";
	    }

}
