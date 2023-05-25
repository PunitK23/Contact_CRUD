package com.punitit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.punitit.Entity.Contact;
import com.punitit.constants.AppConstants;
import com.punitit.service.ContactService;

@Controller
public class ViewContactsController {

	private ContactService contactService;
	
	public ViewContactsController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/editContact")
	public ModelAndView editContact(@RequestParam ("cid")Integer contactId) {
		ModelAndView mav = new ModelAndView();
		Contact cobj = contactService.getContactById(contactId);
		mav.addObject(AppConstants.CONTACT, cobj);
		mav.setViewName(AppConstants.CONTACT);
		return mav;
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam ("cid")Integer contactId) {
		
		contactService.deleteContctById(contactId);
		return "redirect:viewContacts";
	}
	
}
