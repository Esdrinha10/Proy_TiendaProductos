package Tienda_proyecto.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import Tienda_proyecto.Interface.IProduct;
import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbproductos;

@Service
public class ProductService implements IService<tbproductos,Integer> {

	@Autowired
	private IProduct _Product;
	
	@Override
	public List<tbproductos> List() {
		List<tbproductos> users = (List<tbproductos>) _Product.findAll();
		return users;
	}

	@Override
	public Optional<tbproductos> Find(Integer id) {
		return _Product.findById(id);
	}

	@Override
	public int Create(tbproductos data) {
		int response = 0;
		tbproductos producto = _Product.save(data);
		if(!producto.equals(null)) {
			response = 1;
		}
		return response;
	}

	@Override
	public int DeleteLogic(Integer Id, Integer Mod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(tbproductos data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(Integer Id) {
		_Product.deleteById(Id);
		return 0;
	}

}
