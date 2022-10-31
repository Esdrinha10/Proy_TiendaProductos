package Tienda_proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Tienda_proyecto.InterfaceService.IEncryptPassword;
import Tienda_proyecto.Models.tbusuarios;

@Controller
public class AccessController {
	
	@Autowired
	IEncryptPassword _IEncryptPassword;
	
	@GetMapping({"/login","/"})
	public String Login(Model model) {
		model.addAttribute("usuario",new tbusuarios());
		return "Layout/Login";
	}
	
	@PostMapping("/StartSesion")
	public String Login(@Validated tbusuarios usuario,Model model) {
		if(_IEncryptPassword.Login(usuario)) {
			return "redirect:/users/index";
		}else {
			return "redirect:/login?error=true";	
		}
	}
}
