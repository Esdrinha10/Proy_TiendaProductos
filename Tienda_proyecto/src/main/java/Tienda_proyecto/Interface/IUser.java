package Tienda_proyecto.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tienda_proyecto.Models.tbusuarios;

@Repository
public interface IUser extends CrudRepository<tbusuarios,Long> {

}
