package com.tecdesoftware.market.persistence;

import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Le dice a Spring que este repositorio se conecta con la BD
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //Me va a dar todos los productos de mi BD
    public List<Producto> getAll() {
        //Conviertiendo un Iterable<T> a una lista de productos List<Producto>
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //Obtener los productos por categoria
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos (int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,     true);
    }

    //Obtener un producto dado el id
    public Optional<Producto> getProductoByID(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    // Guardar un producto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    // Borrar un producto
    public void delete(Producto producto) {
        productoCrudRepository.delete(producto);
    }

}
