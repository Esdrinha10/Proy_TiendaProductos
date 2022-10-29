package Tienda_Productos.Interfaces;

import org.springframework.data.repository.CrudRepository;

public interface IRepository<Table> extends CrudRepository<Table,Integer> {

}
