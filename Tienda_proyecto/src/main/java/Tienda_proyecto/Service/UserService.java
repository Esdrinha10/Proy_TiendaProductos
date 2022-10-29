package Tienda_proyecto.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tienda_proyecto.Interface.IUser;
import Tienda_proyecto.InterfaceService.IUserService;
import Tienda_proyecto.Models.tbusuarios;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUser _user;
	
	@Override
	public List<tbusuarios> List() {
		return (List<tbusuarios>)_user.findAll();
	}

	@Override
	public Optional<tbusuarios> Find(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int Create(tbusuarios data) {
		int response = 0;
		data.setUsu_Estado((long) 1);
		data.setUsu_UsuarioCrea((long) 1);
		tbusuarios user = _user.save(data);
		if(!user.equals(null)) {
			response = 1;
		}
		return response;
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