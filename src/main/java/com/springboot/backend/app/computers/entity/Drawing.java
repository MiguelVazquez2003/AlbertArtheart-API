package com.springboot.backend.app.computers.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "drawings")
public class Drawing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2991063859061031988L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion", length = 1000)
	private String descripcion;


	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "dia_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date diaCreacion;
	
	@Column(name = "categoria")
    private String categoria;
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getDiaCreacion() {
		return diaCreacion;
	}

	public void setDiaCreacion(Date diaCreacion) {
		this.diaCreacion = diaCreacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
