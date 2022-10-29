package Tienda_Productos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Tienda_Productos.Models.tbusuarios;
import Tienda_Productos.Service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	private UserService _userService;
	
	@GetMapping("/User/List")
	public String Listar(Model model) {
		List<tbusuarios> tbusariosList = _userService.List();
		model.addAttribute("usuarios", tbusariosList);
		return "Index";
	}
}
