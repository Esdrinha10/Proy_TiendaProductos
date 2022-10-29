package Tienda_proyecto.InterfaceService;

import java.util.List;
import java.util.Optional;

public interface IRepositoryService<T> {
	public List<T> List();
	public Optional<T> Find(int id);
	public int Create(T data);
	public int Delete(int Id, int Mod);
	public int Update(T data);
}
