package Tienda_proyecto.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="tbproductos")
public class tbproductos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Integer Pro_Id;
	
	@Column(name="pro_descripcion")
	private String Pro_Descripcion;
	
	@Column(name="cat_id")
	private Integer Cat_Id;
	
	@Column(name="pro_precio_venta")
	@Value("${Pro_Precio_Venta: 0.00}")
	private Double Pro_Precio_Venta;
	
	@Column(name="pro_precio_compra")
	@Value("${Pro_Precio_Compra: 0.00}")
	private Double Pro_Precio_Compra;
	
	@Column(name="pro_usuario_crea")
	private Integer Pro_Usuario_Crea;
	
	@Column(name="pro_fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Pro_Fecha_Creacion;
	
	@Column(name="pro_usuario_modifica")
	private Integer Pro_Usuario_Modifica;
	
	@Column(name="pro_fecha_modifica")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Pro_Fecha_Modifica;
	
	@ManyToOne
	@JoinColumn(name="cat_id",insertable=false, updatable = false)
	private tbcategorias Categoria;
	
	// CONSTRUCTORS
	
	public tbproductos() {
		
	}

	public tbproductos(Integer pro_Id, String pro_Descripcion, Integer cat_Id, Double pro_Precio_Venta,
			Double pro_Precio_Compra, Integer pro_Usuario_Crea, Date pro_Fecha_Creacion, Integer pro_Usuario_Modifica,
			Date pro_Fecha_Modifica, tbcategorias categoria) {
		super();
		Pro_Id = pro_Id;
		Pro_Descripcion = pro_Descripcion;
		Cat_Id = cat_Id;
		Pro_Precio_Venta = pro_Precio_Venta;
		Pro_Precio_Compra = pro_Precio_Compra;
		Pro_Usuario_Crea = pro_Usuario_Crea;
		Pro_Fecha_Creacion = pro_Fecha_Creacion;
		Pro_Usuario_Modifica = pro_Usuario_Modifica;
		Pro_Fecha_Modifica = pro_Fecha_Modifica;
		Categoria = categoria;
	}


	// EVENTS
	@PrePersist
	public void prePersist() {
		this.Pro_Usuario_Crea = 1;
		this.Pro_Fecha_Creacion = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.Pro_Usuario_Modifica = 1;
		this.Pro_Fecha_Modifica = new Date();
	}
	
	
	// GETs AND SETs
	public Integer getPro_Id() {
		return this.Pro_Id;
	}

	public void setPro_Id(Integer pro_Id) {
		this.Pro_Id = pro_Id;
	}

	public String getPro_Descripcion() {
		return Pro_Descripcion;
	}

	public void setPro_Descripcion(String pro_Descripcion) {
		this.Pro_Descripcion = pro_Descripcion;
	}

	public Integer getCat_Id() {
		return this.Cat_Id;
	}

	public void setCat_Id(Integer cat_Id) {
		this.Cat_Id = cat_Id;
	}

	public Double getPro_Precio_Venta() {
		return this.Pro_Precio_Venta;
	}

	public void setPro_Precio_Venta(Double pro_Precio_Venta) {
		this.Pro_Precio_Venta = pro_Precio_Venta;
	}

	public Double getPro_Precio_Compra() {
		return this.Pro_Precio_Compra;
	}

	public void setPro_Precio_Compra(Double pro_Precio_Compra) {
		this.Pro_Precio_Compra = pro_Precio_Compra;
	}

	public Integer getPro_Usuario_Crea() {
		return this.Pro_Usuario_Crea;
	}

	public void setPro_Usuario_Crea(Integer pro_Usuario_Crea) {
		this.Pro_Usuario_Crea = pro_Usuario_Crea;
	}

	public Date getPro_Fecha_Creacion() {
		return this.Pro_Fecha_Creacion;
	}

	public void setPro_Fecha_Creacion(Date pro_Fecha_Creacion) {
		this.Pro_Fecha_Creacion = pro_Fecha_Creacion;
	}

	public Integer getPro_Usuario_Modifica() {
		return this.Pro_Usuario_Modifica;
	}

	public void setPro_Usuario_Modifica(Integer pro_Usuario_Modifica) {
		this.Pro_Usuario_Modifica = pro_Usuario_Modifica;
	}

	public Date getPro_Fecha_Modifica() {
		return this.Pro_Fecha_Modifica;
	}

	public void setPro_Fecha_Modifica(Date pro_Fecha_Modifica) {
		this.Pro_Fecha_Modifica = pro_Fecha_Modifica;
	}

	public tbcategorias getCategoria() {
		return this.Categoria;
	}

	public void setCategoria(tbcategorias categoria) {
		this.Categoria = categoria;
	}
	
	
	
}


