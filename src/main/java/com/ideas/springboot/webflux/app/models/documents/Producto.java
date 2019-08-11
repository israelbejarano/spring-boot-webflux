package com.ideas.springboot.webflux.app.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Producto. Documento para mapear productos en BBDD
 * @author Israel Bejarano
 */
@Document(collection = "productos")
public class Producto {
	
	/** The id. */
	@Id
	private String id;
	
	/** The nombre. */
	private String nombre;
	
	/** The precio. */
	private Double precio;
	
	/** The create at. */
	private Date createAt;
	
	/**
	 * Instantiates a new producto.
	 */
	public Producto() {}

	/**
	 * Instantiates a new producto.
	 *
	 * @param nombre the nombre
	 * @param precio the precio
	 */
	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	
	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	/**
	 * Gets the creates the at.
	 *
	 * @return the creates the at
	 */
	public Date getCreateAt() {
		return createAt;
	}
	
	/**
	 * Sets the creates the at.
	 *
	 * @param createAt the new creates the at
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}