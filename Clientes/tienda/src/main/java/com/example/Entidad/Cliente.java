package com.example.Entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nombre")
private String nombre;

@Column(name = "email")
private String email;

@Column(name = "telefono")
private int telefono;


// Getters y setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
} 

public void setNombre (String nombre) {
    this.nombre = nombre;
}

public String getEmail() {
    return email;
}
 
public void setEmail(String email) {
    this.email = email;
}

public int getTelefono() {
    return telefono;
}

public void setTelefono(int telefono) {
    this.telefono = telefono;
}
    
}
