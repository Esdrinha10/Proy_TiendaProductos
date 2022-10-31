package Tienda_proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import Tienda_proyecto.Interface.IUser;
import Tienda_proyecto.InterfaceService.IEncryptPassword;
import Tienda_proyecto.Models.tbusuarios;

@Service
public class EncryptPasswordService implements IEncryptPassword{

	@Autowired
	private IUser _user;
	
	@Override
	public String EncryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean VerifyPassword(String OriginalPassword, String HashPassword) {
		return BCrypt.checkpw(OriginalPassword, HashPassword);
	}
	
	@Override
	public boolean Login(tbusuarios data) {
		Boolean passConfirm = false;
		List<tbusuarios> users = (List<tbusuarios>) _user.findAll();
		users.removeIf(x-> x.getUsu_Usuario() == data.getUsu_Usuario());
		
		if(!users.isEmpty()) {
			passConfirm = VerifyPassword(
				data.getUsu_Clave(), users.get(0).getUsu_Clave()
			);
		}
		
		if(passConfirm) {
			//ession
		}
		
		return passConfirm;
	}

}


