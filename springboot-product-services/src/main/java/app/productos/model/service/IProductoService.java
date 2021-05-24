package app.productos.model.service;

import app.productos.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    Producto findById(Long id);
}
