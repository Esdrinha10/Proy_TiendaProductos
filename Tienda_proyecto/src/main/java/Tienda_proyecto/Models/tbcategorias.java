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
@Table(name="tbcategorias")
public class tbcategorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_id")
	private Integer Cat_Id;
	
	@Column(name="cat_descripcion")
	private String Cat_Descripcion;
	
	@Column(name="cat_usuario_crea")
	@Value("${Usu_Estado: 1}")
	private Integer Cat_Usuario_Crea;
	
	@Column(name="cat_fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Cat_Fecha_Creacion;
	
	@Column(name="cat_usuario_modifica")
	@Value("${Usu_Estado: 1}")
	private Integer Cat_Usuario_Modifica;
	
	@Column(name="cat_fecha_modifica")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Cat_Fecha_Modifica;
	
	// CONSTRUCTORS 
	
	public tbcategorias() {
		// TODO Auto-generated method stub
	}

	public tbcategorias(Integer cat_Id, String cat_Descripcion, Integer cat_UsuarioCrea, Date cat_Fecha_Creacion,
			Integer cat_Usuario_Modifica, Date cat_Fecha_Modifica) {
		super();
		this.Cat_Id = cat_Id;
		this.Cat_Descripcion = cat_Descripcion;
		this.Cat_Usuario_Crea = cat_UsuarioCrea;
		this.Cat_Fecha_Creacion = cat_Fecha_Creacion;
		this.Cat_Usuario_Modifica = cat_Usuario_Modifica;
		this.Cat_Fecha_Modifica = cat_Fecha_Modifica;
	}
	
	// EVENTS CLASS
	@PrePersist
	public void prePersist() {
		this.Cat_Usuario_Crea =  1;
		this.Cat_Fecha_Creacion = new Date();
		//this.Usu_Estado = (long) 1;
	}
	
	@PreUpdate
	public void preUpdate() {
		this.Cat_Usuario_Modifica = 1;
		this.Cat_Fecha_Modifica = new Date();
	}

	
	// GETs SETs METHODS
	
	public Integer getCat_Id() {
		return this.Cat_Id;
	}

	public void setCat_Id(Integer cat_Id) {
		this.Cat_Id = cat_Id;
	}

	public String getCat_Descripcion() {
		return this.Cat_Descripcion;
	}

	public void setCat_Descripcion(String cat_Descripcion) {
		this.Cat_Descripcion = cat_Descripcion;
	}

	public Integer getCat_Usuario_Crea() {
		return this.Cat_Usuario_Crea;
	}

	public void setCat_Usuario_Crea(Integer cat_Usuario_Crea) {
		this.Cat_Usuario_Crea = cat_Usuario_Crea;
	}

	public Date getCat_Fecha_Creacion() {
		return this.Cat_Fecha_Creacion;
	}

	public void setCat_Fecha_Creacion(Date cat_Fecha_Creacion) {
		this.Cat_Fecha_Creacion = cat_Fecha_Creacion;
	}

	public Integer getCat_Usuario_Modifica() {
		return this.Cat_Usuario_Modifica;
	}

	public void setCat_Usuario_Modifica(Integer cat_Usuario_Modifica) {
		this.Cat_Usuario_Modifica = cat_Usuario_Modifica;
	}

	public Date getCat_Fecha_Modifica() {
		return this.Cat_Fecha_Modifica;
	}

	public void setCat_Fecha_Modifica(Date cat_Fecha_Modifica) {
		this.Cat_Fecha_Modifica = cat_Fecha_Modifica;
	}
		
	
}
