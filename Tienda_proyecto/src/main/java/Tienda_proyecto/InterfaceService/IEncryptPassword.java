package Tienda_proyecto.InterfaceService;

import Tienda_proyecto.Models.tbusuarios;

public interface IEncryptPassword {

	String EncryptPassword(String password);
	
	boolean VerifyPassword(String OriginalPassword,String HashPassword);
	
	boolean Login(tbusuarios data);
}
