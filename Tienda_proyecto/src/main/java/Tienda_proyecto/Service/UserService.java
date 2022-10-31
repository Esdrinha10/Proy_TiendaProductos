package Tienda_proyecto.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tienda_proyecto.Interface.IUser;
import Tienda_proyecto.InterfaceService.IService;
import Tienda_proyecto.Models.tbproductos;
import Tienda_proyecto.Models.tbusuarios;


@Service
public class UserService implements IService<tbusuarios,Integer>  {

	@Autowired
	private IUser _user;
	
	@Override
	public List<tbusuarios> List() {
		
		List<tbusuarios> users = (List<tbusuarios>) _user.findAll();
		users.removeIf(x-> x.getUsu_Estado() == 0);
		return users;
	}

	@Override
	public Optional<tbusuarios> Find(Integer id) {
		return 
			_user.findById(id);
	}

	@Override
	public int Create(tbusuarios data) {
		int response = 0;
		tbusuarios user = _user.save(data);
		if(!user.equals(null)) {
			response = 1;
		}
		return response;
	}

	@Override
	public int DeleteLogic(Integer Id, Integer Mod) {
		tbusuarios userRequest = _user.findById(Id).get();
		userRequest.setUsu_Estado(0);
		userRequest.setUsu_UsuarioElimina(Mod);
		userRequest.setUsu_FechaElimina(new Date());
		_user.save(userRequest);
		return 1;
	}
	
	@Override
	public int Delete(Integer Id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(tbusuarios data) {
		int response = 0;
		tbusuarios actualUser = this.Find(data.getUsu_Id()).get();
		
		data.setUsu_FechaCreacion(actualUser.getUsu_FechaCreacion());
		data.setUsu_UsuarioCrea(actualUser.getUsu_UsuarioCrea());
		data.setUsu_Estado(actualUser.getUsu_Estado());
		
		tbusuarios state = _user.save(data);
		if(!state.equals(null)) {
			response = 1;
		}
		return response;
		
	}

	

}