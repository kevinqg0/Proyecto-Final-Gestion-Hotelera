package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import interfaces.IEstadohabitacion;
import model.Estadohabitacion;

public class ClassEstadohabitacionImp implements IEstadohabitacion {

    private EntityManager em;

    public ClassEstadohabitacionImp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        em = emf.createEntityManager();
    }

    @Override
    public List<Estadohabitacion> listaEstadoHabitacion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        EntityManager emanager = emf.createEntityManager();
        emanager.getTransaction().begin();
        List<Estadohabitacion> listadoestadohabitacion = emanager
                .createQuery("SELECT e FROM Estadohabitacion e", Estadohabitacion.class)
                .getResultList();
        emanager.getTransaction().commit();
        emanager.close();
        return listadoestadohabitacion;
    }

    public Estadohabitacion findEstadohabitacionById(int id) {
        return em.find(Estadohabitacion.class, id);
    }
}

