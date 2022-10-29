package Tienda_proyecto.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import Tienda_proyecto.InterfaceService.IUserService;
import Tienda_proyecto.Models.tbusuarios;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private IUserService _UserService;
	
	@GetMapping("/users/index")
    public String Index(Model model){
		model.addAttribute("usuarios", _UserService.List());
		System.out.print(_UserService.List());
        return "User_Index";
    }
	
	@GetMapping("/users/new")
    public String Insert(Model model){
		model.addAttribute("usuario", new tbusuarios());
        return "User_Create";
    }
	
	@PostMapping("/Save")
    public String Save(@Validated tbusuarios data,Model model){
    	data.setUsu_UsuarioModifica((long) 1);
    	_UserService.Create(data);
        return "redirect:/users/index";
    }

	
}
