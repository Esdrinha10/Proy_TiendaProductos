package Tienda_proyecto.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbcategorias;
import Tienda_proyecto.Models.tbproductos;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IService<tbproductos,Integer> _ProductService;
	
	@Autowired
	IService<tbcategorias,Integer> _CategoryService;
	
	@GetMapping("/index")
    public String Index(Model model){
		List<tbproductos> products = _ProductService.List();
		model.addAttribute("productos", products);
        return "product/Product_Index";
    }
	
	@GetMapping("/new")
    public String Create(Model model){
		List<tbcategorias> categories = _CategoryService.List();
		model.addAttribute("producto", new tbproductos());
		model.addAttribute("categorias", categories);
		model.addAttribute("tittle", "Crear producto");
		model.addAttribute("target", "/products/save");
        return "product/Product_Save";
    }
	
	@GetMapping("/edit/{id}")
    public String Edit(@PathVariable Integer id, Model model){
		List<tbcategorias> categories = _CategoryService.List();
		Optional<tbproductos> product = _ProductService.Find(id);
		model.addAttribute("producto", product);
		model.addAttribute("categorias", categories);
		model.addAttribute("tittle", "Actualizar producto");
		model.addAttribute("target", "/products/update");
        return "product/Product_Save";
    }
	
	@PostMapping("/save")
    public String Save(@Validated tbproductos data, Model model){
		_ProductService.Create(data);
        return "redirect:/products/index?successCreate=true";
    }
	
	@PostMapping("/update")
    public String Update(@Validated tbproductos data, Model model){
		_ProductService.Update(data);
        return "redirect:/products/index?successUpdate=true";
    }
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
		_ProductService.Delete(id);
		return "redirect:/products/index?successDelete=true";
    }
}


