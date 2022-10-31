package Tienda_proyecto.InterfaceService;

public interface IEncryptPassword {

	String EncryptPassword(String password);
	
	boolean VerifyPassword(String OriginalPassword,String HashPassword);
}
