package Tienda_proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Tienda_proyecto.InterfaceService.IRepositoryService;
import Tienda_proyecto.Models.tbusuarios;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private IRepositoryService<tbusuarios> _UserService;
	
	@GetMapping("/Index")
	public String Listar(Model model) {
		List<tbusuarios> usuarios = _UserService.List();
		model.addAttribute("usuarios", usuarios);
		return "Index";
	}
}
