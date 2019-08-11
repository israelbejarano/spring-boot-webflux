package com.ideas.springboot.webflux.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ideas.springboot.webflux.app.models.documents.Producto;

/**
 * The Interface ProductoDao.
 * @author Israel Bejarano
 */
public interface ProductoDao extends ReactiveMongoRepository<Producto, String> {

}