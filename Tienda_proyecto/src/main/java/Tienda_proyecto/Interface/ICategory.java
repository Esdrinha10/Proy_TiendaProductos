package Tienda_proyecto.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tienda_proyecto.Models.tbcategorias;

@Repository
public interface ICategory extends CrudRepository<tbcategorias,Integer> {

}
