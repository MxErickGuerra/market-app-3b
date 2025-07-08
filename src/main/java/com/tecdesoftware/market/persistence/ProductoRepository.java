package com.tecdesoftware.market.persistence;

import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository{

    private ProductoCrudRepository productoCrudRepository;

    //Equivalente a poner Select * from productos
    public List<Producto> getAll(){
        return (List<Producto>)  productoCrudRepository.findAll();
    }
    public List <Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNameAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanandEstado(cantidad,true);
    }
    //Obtener un producto dado el id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    //Guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    //eliminar producto por Id
    public void delete(Producto producto){
        productoCrudRepository.delete(producto);
    }
}
