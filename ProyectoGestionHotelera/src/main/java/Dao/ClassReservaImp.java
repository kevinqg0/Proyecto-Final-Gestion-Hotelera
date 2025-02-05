package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IReserva;
import model.Reserva;

public class ClassReservaImp implements IReserva {

	public void RegistrarReserva(Reserva re) {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		// permite gestionar entidades
		EntityManager em = fabr.createEntityManager();
		// iniciar transaccion
		em.getTransaction().begin();
		// registramos
		em.persist(re);
		// emitimos mensaje por consola
		System.out.println("Reserva registrada en la BD correctamente");
		// confirmamos
		em.getTransaction().commit();
		// cerramos la transaccion
		em.close();
	}// fin de metodo registrar reserva

	public void ActualizarReserva(Reserva re) {
		// establecer la conexion con la unidad de persistencia...
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		// gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		// inicar la transaccion
		emanager.getTransaction().begin();
		// Actualizar
		emanager.merge(re);
		// Emitimos mensaje
		System.out.println("Reserva actualizada correctamente en la BD");
		// confirmamos
		emanager.getTransaction().commit();
		// cerramos
		emanager.close();
	}// fin de metodo actualizar reserva

	public Reserva BuscarReserva(Reserva re) {
		// Establecemos la conexi贸n con la unidad de persistencia...
		EntityManagerFactory fbr = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		// Gestionar las entidades
		EntityManager emanager = fbr.createEntityManager();
		// Iniciamos la transacci贸n
		emanager.getTransaction().begin();
		// Recuperamos el codigo a buscar...
		Reserva buscarre = emanager.find(Reserva.class, re.getID_Reserva());
		// Confirmamos
		emanager.getTransaction().commit();
		// Cerramos
		emanager.close();
		// Retornamos reserva buscada de la BD
		return buscarre;
	}// fin de metodo buscar reserva

	public void EliminarReserva(Reserva re) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    Reserva reservaToDelete = em.find(Reserva.class, re.getID_Reserva());
	    
	    if (reservaToDelete != null) {
	        em.remove(reservaToDelete);
	        System.out.println("Reserva eliminada de la BD correctamente");
	    } else {
	        System.out.println("No se encontr贸 la reserva para eliminar");
	    }
	    
	    em.getTransaction().commit();
	    em.close();
		
	}// fin de metodo eliminar reserva

	@Override
	public List<Reserva> listaReserva() {
		// Establecer la conexi贸n con la undidad de persistencia
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		// Gestionar entidades
		EntityManager emanager = em.createEntityManager();
		// Iniciamos la transaccion
		emanager.getTransaction().begin();
		// Recuperamos el listado de reserva de la base de datos
		// aplicamos consultas JPQL
		List<Reserva> listadoreserva = emanager.createQuery("select r from Reserva r JOIN FETCH r.cliente JOIN FETCH r.habitacion", Reserva.class).getResultList();
		// confirmamos
		emanager.getTransaction().commit();
		// Cerramos
		emanager.close();
		// retornamos el listado de reserva a la BD
		return listadoreserva;
	}

} // fin de la clase