package com.spring.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateEmailController {

	private String updateEmailPage = "template/update-email";

	@RequestMapping(value = "/updateEmail", method = RequestMethod.GET)
	public String getUpdateEmailPage(Model model) {
		model.addAttribute("page", updateEmailPage);
		return "account";
	}
}
