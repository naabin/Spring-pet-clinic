package com.petclinic.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;





@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {

		this.ownerService = ownerService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}	
	@RequestMapping("/find")
	public String findOwners(Model model) {
		model.addAttribute("owner", new Owner());
		return "owners/findOwners";
	}
	
	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		
		if(owner.getLastName() == null) {
			owner.setLastName("");
		}
		Set<Owner> results = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		if(results.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		}
		else if (results.size() == 1) {
			owner = results.iterator().next();
			return "redirect:/owners/"+owner.getId();
		}
		else {
			model.addAttribute("selections", results);
		}
		return "owners/ownersList";
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView modelAndView = new ModelAndView("/owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(ownerId));
		return modelAndView;
	}
	
	
	
	@GetMapping("/new")
	public String initProcessCreateForm(Model model) {
		Owner owner = new Owner();
		model.addAttribute("owner", owner);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		
	}
	
	@PostMapping("/new")
	public String processCreationForm(@Valid Owner owner, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			Owner savedOwner = this.ownerService.save(owner);
			return "redirect:/owners/"+ savedOwner.getId();
		}
	}
	
	@GetMapping("/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable("ownerId") Long id, Model model) {
		model.addAttribute(this.ownerService.findById(id));
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/{ownerId}/edit")
	public String processOrUpdateOwnerForm(@Valid Owner owner, 
			BindingResult bindingResult, @PathVariable("ownerId") Long ownerId) {
		
		if(bindingResult.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			owner.setId(ownerId);
			this.ownerService.save(owner);
			return "redirect:/owners/{ownerId}";
		}
	}
}
