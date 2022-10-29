package Tienda_Productos.Service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Tienda_Productos.InterfaceService.IRepositoryService;
import Tienda_Productos.Interfaces.IRepository;
import Tienda_Productos.Models.tbusuarios;

public class UserService implements IRepositoryService<tbusuarios> {

	@Autowired
	private IRepository<tbusuarios> data;
	
	@Override
	public List<tbusuarios> List() {
		return (List<tbusuarios>)data.findAll();
	}

	@Override
	public Optional<tbusuarios> Find(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int Create(tbusuarios data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(int Id, int Mod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(tbusuarios data) {
		// TODO Auto-generated method stub
		return 0;
	}

}
