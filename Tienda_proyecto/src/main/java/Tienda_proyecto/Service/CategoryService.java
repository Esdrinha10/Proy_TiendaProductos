package Tienda_proyecto.Service;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tienda_proyecto.Interface.ICategory;
import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbcategorias;

@Service
public class CategoryService implements IService<tbcategorias,Integer>  {

	@Autowired
	private ICategory _category;
	
	@Override
	public List<tbcategorias> List() {
		return 
			(List<tbcategorias>) _category.findAll();
	}

	@Override
	public Optional<tbcategorias> Find(Integer id) {
		return _category.findById(id);
	}

	@Override
	public int Create(tbcategorias data) {
		int response = 0;
		tbcategorias category = _category.save(data);
		if(!category.equals(null)) {
			response = 1;
		}
		return response;
	}

	@Override
	public int Delete(Integer Id) {
		_category.deleteById(Id);
		return 0;
	}
	
	@Override
	public int DeleteLogic(Integer Id, Integer Mod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(tbcategorias data) {
		
		int response = 0;
		tbcategorias actualCategory = this.Find(data.getCat_Id()).get();
		
		data.setCat_Fecha_Creacion(actualCategory.getCat_Fecha_Creacion());
		data.setCat_Usuario_Crea(actualCategory.getCat_Usuario_Crea());
		
		tbcategorias state = _category.save(data);
		if(!state.equals(null)) {
			response = 1;
		}
		return response;
	}


}
