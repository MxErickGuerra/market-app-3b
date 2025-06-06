package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "compras")
public class Compra {

    @Id //Llave primaria
    //Hace el id autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    //Relación con la entidad Cliente: Muchas complras a un cliente
    @ManyToOne
    //No quiero que se modifique la entidad cliente, solo relacionarla
    @JoinColumn (name="id_cliente", insertable=false, updatable=false)
    private Cliente cliente;

    //Relación con la entidad CompraProducto: Una compra con muchos productos
    @OneToMany(mappedBy = "producto")
    private List<Producto> productos;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
