package com.example.Entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nombre")
private String nombre;

@Column(name = "precio")
private int precio;

@Column(name = "CantidadEnStock")
private int cantidadEnStock;

//Getters y setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getPrecio() {
    return precio;
}

public void setPrecio(int precio) {
    this.precio = precio;
}

public int getStock() {
    return cantidadEnStock;
}

public void setStock(int cantidadEnStock) {
    this.cantidadEnStock = cantidadEnStock;
}


}
