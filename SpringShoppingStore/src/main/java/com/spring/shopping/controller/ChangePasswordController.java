package com.spring.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.shopping.model.Customer;
import com.spring.shopping.service.CustomerService;
import com.spring.shopping.util.SessionUtils;

@Controller
public class ChangePasswordController {

	private String changePasswordPage = "template/changepassword";
	@Autowired
	private CustomerService customerService;
	@SuppressWarnings("unused")
	private HttpSession session;

	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public String getChangePasswordPage(HttpServletRequest request,
			Model model, Boolean flag) {
		model.addAttribute("page", changePasswordPage);
		if (flag != null) {
			model.addAttribute("flag", flag);
		}
		return "account";
	}

	@RequestMapping(value = "changepassword", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request,
			@RequestParam("password1") String password1,
			@RequestParam("password2") String password2, Model model,
			RedirectAttributes redirectAttributes) {
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		boolean flag = customerService.changePassword(password1, customer);
		redirectAttributes.addFlashAttribute("flag", flag);
		return "redirect:/change-password";
	}
}
