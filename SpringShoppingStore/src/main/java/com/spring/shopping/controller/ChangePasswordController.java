package com.spring.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChangePasswordController {

	private String changePasswordPage = "template/changepassword";

	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public String getChangePasswordPage(HttpServletRequest request, Model model) {
		model.addAttribute("page", changePasswordPage);
		return "account";
	}

}
