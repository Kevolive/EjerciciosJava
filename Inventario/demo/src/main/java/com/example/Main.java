package com.example;

import com.example.Entidad.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearProducto("Celular Samsung", 1500, 5);
        Producto producto = leerProducto(1L);

        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre());
        }
        actualizarProducto(1L, "Celular Samsung A04", 1600, 4);

    }

    public static void crearProducto(String nombre, int precio, int cantidadEnStock) {
        EntityManager em = emf.createEntityManager();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(cantidadEnStock);

        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    public static Producto leerProducto(Long id) {
        EntityManager em = emf.createEntityManager();
        Producto producto = em.find(Producto.class, id);

        em.close();
        return producto;
    }

    public static void actualizarProducto(Long id, String nuevoNombre, int nuevoPrecio, int nuevoStock) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Producto producto = em.find(Producto.class, id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);
            em.merge(producto);

        }
        em.getTransaction().commit();
        em.close();
    }
    public static void eliminarProducto(Long id) {
        EntityManager em = emf.createEntityManager();
        Producto producto = em.find(Producto.class, id);
        if (producto != null) {
            em.remove(producto);
        }
        em.getTransaction().commit();
        em.close();
    }
}