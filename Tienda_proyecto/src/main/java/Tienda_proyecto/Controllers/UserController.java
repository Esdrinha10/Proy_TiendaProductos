package Tienda_proyecto.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
		List<tbusuarios> users = _UserService.List();
		users.removeIf(x-> x.getUsu_Estado() == 0);
		model.addAttribute("usuarios", users);
        return "User_Index";
    }
	
	@GetMapping("/users/new")
    public String Insert(Model model){
		model.addAttribute("usuario", new tbusuarios());
        return "User_Create";
    }
	
	@GetMapping("/users/edit/{id}")
    public String Update(@PathVariable long id,Model model){
		Optional<tbusuarios> user = _UserService.Find(id);
		model.addAttribute("usuario", user);
        return "User_Create";
    }
	
	@GetMapping("/users/delete/{id}")
    public String delete(@PathVariable long id,Model model){
		_UserService.Delete((long) id, (long) 1);
		return "redirect:/users/index";
    }
	
	@PostMapping("/Save")
    public String Save(@Validated tbusuarios data,Model model){
    	data.setUsu_UsuarioModifica((long) 1);
    	_UserService.Create(data);
        return "redirect:/users/index";
    }

	
}
