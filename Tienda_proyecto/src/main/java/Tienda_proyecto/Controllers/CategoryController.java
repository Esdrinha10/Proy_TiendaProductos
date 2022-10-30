package Tienda_proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbcategorias;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private IService<tbcategorias,Integer> _CategoryService;
	
	@GetMapping("/index")
    public String Index(Model model){
		List<tbcategorias> categories = _CategoryService.List();
		model.addAttribute("categorias", categories);
		model.addAttribute("categoria", new tbcategorias());
        return "category/Category_Index";
    }
	
	@PostMapping("/save")
    public String Save(@Validated tbcategorias data,Model model){
    	_CategoryService.Create(data);
        return "redirect:index?successCreate=true";
    }
	
	@PostMapping("/update")
    public String Update(@Validated tbcategorias data, Model model){
    	_CategoryService.Update(data);
        return "redirect:index?successUpdate=true";
    }
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
		_CategoryService.Delete(id);
		  return "redirect:/categories/index?successDelete=true";
    }
	
	// REST API METHODS
	
	@RequestMapping("/getCategories")
	@ResponseBody
    public List<tbcategorias> getCategories(@RequestParam("id") Integer id) {
	 	List<tbcategorias> Categories = _CategoryService.List();
	 	if(id != 0) {
	 		Categories.removeIf(category -> category.getCat_Id() != id);
	 	}
	 	
	 	return Categories;
	 }
}
