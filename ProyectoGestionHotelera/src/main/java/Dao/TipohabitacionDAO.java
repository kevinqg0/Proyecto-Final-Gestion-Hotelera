package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import model.Tipohabitacion;

public class TipohabitacionDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");

    public List<Tipohabitacion> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Tipohabitacion t", Tipohabitacion.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Tipohabitacion findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Tipohabitacion.class, id);
        } finally {
            em.close();
        }
    }
}

