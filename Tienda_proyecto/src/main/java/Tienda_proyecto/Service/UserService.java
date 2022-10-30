package Tienda_proyecto.Service;


import java.util.Date;
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
		return 
			(List<tbusuarios>)_user.findAll();
	}

	@Override
	public Optional<tbusuarios> Find(long id) {
		// TODO Auto-generated method stub
		return _user.findById(id);
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
	public int Delete(long Id, long Mod) {
		tbusuarios userRequest = _user.findById(Id).get();
		userRequest.setUsu_Estado((long) 0);
		userRequest.setUsu_UsuarioElimina(Mod);
		userRequest.setUsu_FechaElimina(new Date());
		_user.save(userRequest);
		return 1;
	}

	@Override
	public int Update(tbusuarios data) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}