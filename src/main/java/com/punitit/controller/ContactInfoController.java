package com.punitit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.punitit.Entity.Contact;
import com.punitit.constants.AppConstants;
import com.punitit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService contactService;
	
	public ContactInfoController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping(value = {"/loadForm", "/"})
	public String loadForm(Model model) {
		Contact cobj = new Contact(); 
		model.addAttribute(AppConstants.CONTACT, cobj);
		return AppConstants.CONTACT;
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid Contact contact,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return AppConstants.CONTACT;
		}
		
		Boolean contactExists = contactService.isContactExists(contact);
		if(contactExists) {
			model.addAttribute("errMsg", "Duplicate contact found");
			
		}else {
			
			Boolean isSaved = contactService.saveContacts(contact);
			if(isSaved) {
				model.addAttribute("succMsg", "Contact saved Succesfully....!");
			} else {
				model.addAttribute("errMsg", "Contact not saved");
			}
		}
		
		return AppConstants.CONTACT;
	}
	
//	@GetMapping("/viewContacts")
//	public ModelAndView viewAllContacts() {
//		List<Contact> allContacts = contactService.getAllContacts();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("contacts", allContacts); // setting data to model  in key-value
//		mav.setViewName("viewcontacts"); //setting logical view name
//
//		return mav;		
//	}
	
	
	@GetMapping("/viewContacts")
	public ModelAndView viewAllContacts(HttpServletRequest req) {
		
		Integer pageSize = 3;
		Integer pageNo = 1;
		
		String reqParam = req.getParameter("pno");
		if(reqParam!=null && !"".equals(reqParam)) {
			pageNo = Integer.parseInt(reqParam);
		}
		Page<Contact> page = contactService.getAllContactsNew(pageNo-1,pageSize);
		int totalPages = page.getTotalPages();
		List<Contact> allContents = page.getContent();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("contacts", allContents); // setting data to model  in key-value
		mav.addObject("tp", totalPages);
		mav.addObject("currPno", pageNo);
		mav.setViewName("viewcontacts"); //setting logical view name

		return mav;		
	}
}
