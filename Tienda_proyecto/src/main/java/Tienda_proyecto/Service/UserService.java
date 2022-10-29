package Tienda_proyecto.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tienda_proyecto.Interface.IRepository;
import Tienda_proyecto.InterfaceService.IRepositoryService;
import Tienda_proyecto.Models.tbusuarios;


@Service
public class UserService implements IRepositoryService<tbusuarios> {

	@Autowired
	private IRepository<tbusuarios> data;
	
	@Override
	public java.util.List<tbusuarios> List() {
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