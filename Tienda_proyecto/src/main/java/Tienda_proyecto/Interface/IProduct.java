package Tienda_proyecto.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tienda_proyecto.Models.tbproductos;

@Repository
public interface IProduct extends CrudRepository<tbproductos,Integer>{

}
