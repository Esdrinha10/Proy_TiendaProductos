package Tienda_proyecto.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbusuarios;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IService<tbusuarios, Integer> _UserService;
	
	@GetMapping("/index")
    public String Index(Model model){
		List<tbusuarios> users = _UserService.List();
		model.addAttribute("usuarios", users);
        return "User_Index";
    }
	
	@GetMapping("/new")
    public String Insert(Model model){
		model.addAttribute("usuario", new tbusuarios());
		model.addAttribute("title", "Crear un nuevo usuario");
        return "User_Create";
    }
	
	@GetMapping("/edit/{id}")
    public String Update(@PathVariable Integer id,Model model){
		Optional<tbusuarios> user = _UserService.Find(id);
		model.addAttribute("usuario", user);
		model.addAttribute("title", "Editar usuario");
        return "User_Create";
    }
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
		_UserService.DeleteLogic(id, 1);
		return "redirect:/users/index";
    }
	
	@PostMapping("/Save")
    public String Save(@Validated tbusuarios data,Model model){
    	_UserService.Create(data);
        return "redirect:/users/index";
    }

	
	// REST API METHODS
	
	@RequestMapping("/users/getUsers")
    public @ResponseBody List<tbusuarios> getUsers(@RequestParam("id") Integer id) {
	 	List<tbusuarios> users = _UserService.List();
	 	if(id != 0) {
	 		users.removeIf(user -> user.getUsu_Id() != id);
	 	}
	 	
	 	return users;
	 }
	
}
