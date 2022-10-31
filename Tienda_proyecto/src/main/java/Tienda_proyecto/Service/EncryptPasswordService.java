package Tienda_proyecto.Service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import Tienda_proyecto.InterfaceService.IEncryptPassword;

@Service
public class EncryptPasswordService implements IEncryptPassword{

	@Override
	public String EncryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean VerifyPassword(String OriginalPassword, String HashPassword) {
		return BCrypt.checkpw(OriginalPassword, HashPassword);
	}

}
