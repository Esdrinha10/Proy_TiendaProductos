package Tienda_proyecto.InterfaceService;

import java.util.List;
import java.util.Optional;

import Tienda_proyecto.Models.tbusuarios;

public interface IService<T,I> {
	public List<T> List();
	public Optional<T> Find(I id);
	public int Create(T data);
	public int DeleteLogic(I Id, I Mod);
	public int Update(T data);
	public int Delete(I Id);
}
