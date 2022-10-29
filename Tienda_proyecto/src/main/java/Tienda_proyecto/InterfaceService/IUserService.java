package Tienda_proyecto.InterfaceService;

import java.util.List;
import java.util.Optional;

import Tienda_proyecto.Models.tbusuarios;

public interface IUserService {
	public List<tbusuarios> List();
	public Optional<tbusuarios> Find(int id);
	public int Create(tbusuarios data);
	public int Delete(int Id, int Mod);
	public int Update(tbusuarios data);
}
