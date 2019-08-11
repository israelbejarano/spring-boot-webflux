package com.ideas.springboot.webflux.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.springboot.webflux.app.models.dao.ProductoDao;
import com.ideas.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Class ProductoRestController.
 * @author Israel Bejarano
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	
	/** The dao. */
	@Autowired
	private ProductoDao dao;
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	/**
	 * Index.
	 *
	 * @return the flux
	 */
	@GetMapping
	public Flux<Producto> index() {
		Flux<Producto> productos = dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).doOnNext(prod -> log.info(prod.getNombre()));
		return productos;
	}
	
	/**
	 * Show.
	 *
	 * @param id the id
	 * @return the mono
	 */
	@GetMapping("/{id}")
	public Mono<Producto> show(@PathVariable String id) {
		Flux<Producto> productos = dao.findAll();
		Mono<Producto> producto = productos.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getNombre()));
		return producto;
	}
}