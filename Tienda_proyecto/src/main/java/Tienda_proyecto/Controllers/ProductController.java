package Tienda_proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
		model.addAttribute("title", "Crear producto");
        return "product/Product_Save";
    }
	
	@PostMapping("/save")
    public String Save(@Validated tbproductos data, Model model){
		_ProductService.Create(data);
        return "redirect:/products/index?successCreate=true";
    }
}


