package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Estadohabitacion;

public class EstadohabitacionDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");

    public List<Estadohabitacion> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Estadohabitacion e", Estadohabitacion.class).getResultList();
        } finally {
            em.close();  // Asegúrate de cerrar el EntityManager después de usarlo
        }
    }

    public Estadohabitacion findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Estadohabitacion.class, id);
        } finally {
            em.close();
        }
    }
}

