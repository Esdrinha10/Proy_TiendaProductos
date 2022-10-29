package Tienda_Productos.Models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbusuarios")
public class tbusuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Usu_Id;
	public String Usu_Usuario;
	public String Usu_Clave;
	public String Usu_Nombre;
	public String Usu_Apellidos;
	public int Usu_Estado;
	public int Usu_UsuarioCrea;
	public LocalDateTime Usu_FechaCreacion;
	public int Usu_UsuarioModifica;
	public LocalDateTime Usu_FechaModifica;
	public int Usu_UsuarioElimina;
	public LocalDateTime Usu_FechaElimina;	
}
