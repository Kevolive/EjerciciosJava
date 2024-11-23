package com.example;

import com.example.Entidad.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearCliente("Kevin Olivella", "kolivella@cesde.net", 301769017);
        Cliente cliente = leerCliente(1L);

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre());
        }
        actualizarCliente(1L, "Kevin Alfonso Olivella Felizzola", "kevinolivella@gamil.com", 6045088 );
    }

    public static void crearCliente(String nombre, String email, int telefono) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();

    }

    public static Cliente leerCliente(Long id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }
public static void actualizarCliente(Long id, String nuevoNombre, String nuevoEmail, int nuevoTelefono) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Cliente cliente = em.find(Cliente.class, id);
    if (cliente != null) {
        cliente.setNombre(nuevoNombre);
        cliente.setEmail(nuevoEmail);
        cliente.setTelefono(nuevoTelefono);
        em.merge(cliente);
    }
    em.getTransaction().commit();
    em.close();
}

public static void eliminarCliente(Long id) {
    EntityManager em = emf.createEntityManager();
    Cliente cliente = em.find(Cliente.class, id);
    if(cliente != null) {
        em.remove(cliente);
    }
    em.getTransaction().commit();
    em.close();
}

}
