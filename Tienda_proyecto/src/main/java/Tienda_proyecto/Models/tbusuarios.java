package Tienda_proyecto.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="tbusuarios")
public class tbusuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usu_id")
	private Integer Usu_Id;
	
	@Column(name="usu_usuario")
	private String Usu_Usuario;
	
	@Column(name="usu_clave")
	private String Usu_Clave;
	
	@Column(name="usu_nombre")
	private String Usu_Nombre;
	
	@Column(name="usu_apellidos")
	private String Usu_Apellidos;
	
	@Column(name="usu_estado")
	@Value("${Usu_Estado: 1}")
	private Integer Usu_Estado;
	
	@Column(name="usu_usuario_crea")
	@Value("${Usu_UsuarioCrea: 1}")
	private Integer Usu_UsuarioCrea;
	
	@Column(name="Usu_FechaCreacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Usu_FechaCreacion;
	
	@Column(name="usu_usuario_modifica",nullable = true)
	private Integer Usu_UsuarioModifica;
	
	@Column(name="usu_fecha_modifica",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Usu_FechaModifica;
	
	@Column(name="usu_usuario_elimina",nullable = true)
	private Integer Usu_UsuarioElimina;
	
	@Column(name="usu_fecha_elimina",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Usu_FechaElimina;
	
	public tbusuarios() {
		// TODO Auto-generated method stub
	}
	
	public tbusuarios(Integer usu_Id, String usu_Usuario, String usu_Clave, String usu_Nombre, String usu_Apellidos,
			Integer usu_Estado, Integer usu_UsuarioCrea, Date usu_FechaCreacion, Integer usu_UsuarioModifica,
			Date usu_FechaModifica, Integer usu_UsuarioElimina, Date usu_FechaElimina) {
		super();
		this.Usu_Id = usu_Id;
		this.Usu_Usuario = usu_Usuario;
		this.Usu_Clave = usu_Clave;
		this.Usu_Nombre = usu_Nombre;
		this.Usu_Apellidos = usu_Apellidos;
		this.Usu_Estado = usu_Estado;
		this.Usu_UsuarioCrea = usu_UsuarioCrea;
		this.Usu_FechaCreacion = usu_FechaCreacion;
		this.Usu_UsuarioModifica = usu_UsuarioModifica;
		this.Usu_FechaModifica = usu_FechaModifica;
		this.Usu_UsuarioElimina = usu_UsuarioElimina;
		this.Usu_FechaElimina = usu_FechaElimina;
	}

	
	// EVENTS
	
	@PrePersist
	public void prePersist() {
		this.Usu_UsuarioCrea = 1;
		this.Usu_FechaCreacion = new Date();
		this.Usu_Estado =  1;
	}
	
	@PreUpdate
	public void preUpdate() {
		this.Usu_UsuarioModifica = 1;
		this.Usu_FechaModifica = new Date();
	}
	
	//GET SETS METHODS

	public Integer getUsu_Id() {
		return Usu_Id;
	}


	public void setUsu_Id(Integer usu_Id) {
		Usu_Id = usu_Id;
	}


	public String getUsu_Usuario() {
		return Usu_Usuario;
	}


	public void setUsu_Usuario(String usu_Usuario) {
		Usu_Usuario = usu_Usuario;
	}


	public String getUsu_Clave() {
		return Usu_Clave;
	}


	public void setUsu_Clave(String usu_Clave) {
		Usu_Clave = usu_Clave;
	}


	public String getUsu_Nombre() {
		return Usu_Nombre;
	}


	public void setUsu_Nombre(String usu_Nombre) {
		Usu_Nombre = usu_Nombre;
	}


	public String getUsu_Apellidos() {
		return Usu_Apellidos;
	}


	public void setUsu_Apellidos(String usu_Apellidos) {
		Usu_Apellidos = usu_Apellidos;
	}


	public Integer getUsu_Estado() {
		return Usu_Estado;
	}


	public void setUsu_Estado(Integer usu_Estado) {
		Usu_Estado = usu_Estado;
	}


	public Integer getUsu_UsuarioCrea() {
		return Usu_UsuarioCrea;
	}


	public void setUsu_UsuarioCrea(Integer usu_UsuarioCrea) {
		Usu_UsuarioCrea = usu_UsuarioCrea;
	}


	public Date getUsu_FechaCreacion() {
		return Usu_FechaCreacion;
	}


	public void setUsu_FechaCreacion(Date usu_FechaCreacion) {
		Usu_FechaCreacion = usu_FechaCreacion;
	}


	public Integer getUsu_UsuarioModifica() {
		return Usu_UsuarioModifica;
	}


	public void setUsu_UsuarioModifica(Integer usu_UsuarioModifica) {
		Usu_UsuarioModifica = usu_UsuarioModifica;
	}


	public Date getUsu_FechaModifica() {
		return Usu_FechaModifica;
	}


	public void setUsu_FechaModifica(Date usu_FechaModifica) {
		Usu_FechaModifica = usu_FechaModifica;
	}


	public Integer getUsu_UsuarioElimina() {
		return Usu_UsuarioElimina;
	}


	public void setUsu_UsuarioElimina(Integer usu_UsuarioElimina) {
		Usu_UsuarioElimina = usu_UsuarioElimina;
	}


	public Date getUsu_FechaElimina() {
		return Usu_FechaElimina;
	}


	public void setUsu_FechaElimina(Date usu_FechaElimina) {
		Usu_FechaElimina = usu_FechaElimina;
	}	
	
	
}

