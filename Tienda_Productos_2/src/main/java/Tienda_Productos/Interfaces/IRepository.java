package Tienda_Productos.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<Table> extends CrudRepository<Table,Integer> {

}
