package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TelaDeLoginController {
	
	String UsuarioAdm = "admin";
	String SenhaAdm = "A1234567";
	
	String UsuarioComum = "comum";
	String SenhaComum = "C1234567";

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		
		String usuario = loginForm.getUsuario();
		String senha = loginForm.getSenha();
		
		if(UsuarioAdm.equals(usuario) && SenhaAdm.equals(senha)) {
			//usuario adm logou
			model.addAttribute("AdmLogou", true);
			model.addAttribute(usuario);
			return "home";
		}
		else if(UsuarioComum.equals(usuario) && SenhaComum.equals(senha)) {
			//usuario comum logou
			model.addAttribute("ComumLogou", true);
			model.addAttribute(usuario);
			return "home";
		}
		else {
			//falha no login
			model.addAttribute("DadosErrados", true);
			return "index";
		}
		
	}
}
