package com.detail.Detail.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DetailController {
	
	@Autowired
	private DetailService detailService;
	
	@GetMapping("/details")
	public String getDetails(Model model) {
		List<DetailEntity> details = detailService.getAllDetails();
		model.addAttribute("details", details);
		return "details";
	}
	
	@PostMapping("/details")
	public String saveDetails(@ModelAttribute DetailEntity detail) {
		detailService.saveDetails(detail);
		return "redirect:/details";
	}
	
	@PutMapping("/details/{id}")
	public String updateDetail(@PathVariable Long id, @RequestBody DetailEntity detail) {
		detailService.updateDetail(id, detail);
		return "redirect:/details";
	}


}
