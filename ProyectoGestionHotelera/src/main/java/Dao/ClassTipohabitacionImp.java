package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITipohabitacion;
import model.Tipohabitacion;

public class ClassTipohabitacionImp implements ITipohabitacion{
	

	public List<Tipohabitacion> listaTipoHabitacion() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<Tipohabitacion> listadotipohabitacion = emanager.createQuery("SELECT t FROM Tipohabitacion t", Tipohabitacion.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listadotipohabitacion;
	}

    public Tipohabitacion findTipohabitacionById(int id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
    	EntityManager em  = emf.createEntityManager();
        em = emf.createEntityManager();
        return em.find(Tipohabitacion.class, id);
    }
    
} //fin de la clase
