package com.ideas.springboot.webflux.app.controllers;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.ideas.springboot.webflux.app.models.dao.ProductoDao;
import com.ideas.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;

/**
 * The Class ProductoController.
 * @author Israel Bejarano
 */
@Controller
public class ProductoController {
	
	/** The dao. */
	@Autowired
	private ProductoDao dao;
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	/**
	 * Listar.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping({"/listar", "/"})
	public String listar(Model model) {
		Flux<Producto> productos = dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		});
		
		productos.subscribe(prod -> log.info(prod.getNombre()));
		
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productos);
		return "listar";
		
	}

	/**
	 * Listar data driver.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/listar-datadriver")
	public String listarDataDriver(Model model) {
		Flux<Producto> productos = dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).delayElements(Duration.ofSeconds(1));
		
		productos.subscribe(prod -> log.info(prod.getNombre()));
		
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", new ReactiveDataDriverContextVariable(productos, 2));
		return "listar";
	}
	
	/**
	 * Listar full.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/listar-full")
	public String listarFull(Model model) {
		Flux<Producto> productos = dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).repeat(5000);
		
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productos);
		return "listar";	
	}
	
	/**
	 * Listar chunked.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/listar-chunked")
	public String listarChunked(Model model) {
		Flux<Producto> productos = dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).repeat(5000);
		
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productos);
		return "listar-chunked";		
	}
}