package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IHabitacion;
import model.Estadohabitacion;
import model.Habitacion;
import model.Tipohabitacion;

public class ClassHabitacionImp implements IHabitacion {

	public void RegistrarHabitacion(Habitacion hab) {
		//establecer conexion con la unidad de persistencia...
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        //permite gestionar entidades
        EntityManager em=fabr.createEntityManager();
        //iniciar transaccion
        em.getTransaction().begin();
        //registramos
        em.persist(hab);
        //emitimos mensaje por consola
        System.out.println("Habitacion registrada en la BD correctamente");
        //confirmamos
        em.getTransaction().commit();
        //cerramos la transaccion
        em.close();
	}//fin de metodo registrar habitacion

	
	public void ActualizarHabitacion(Habitacion hab) {
		//establecer  la conexion con la unidad de persistencia...
        EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        //gestionar las entidades
        EntityManager emanager= em.createEntityManager();
        //inicar la transaccion
        emanager.getTransaction().begin();
        //Actualizar
        emanager.merge(hab);
        //Emitimos mensaje
        System.out.println("Habitacion actualizado correctamente en la BD");
        //confirmamos
        emanager.getTransaction().commit();
        //cerramos
        emanager.close();
	}//fin de metodo actualizar habitacion

	
	public Habitacion BuscarHabitacion(Habitacion hab) {
		//Establecemos la conexión con la unidad de persistencia...
		EntityManagerFactory fbr = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		//Gestionar las entidades
		EntityManager emanager = fbr.createEntityManager();
		//Iniciamos la transacción
		emanager.getTransaction().begin();
		//Recuperamos el codigo a buscar...
		Habitacion buscarhab = emanager.find(Habitacion.class, hab.getID_Habitacion());
		//Confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//Retornamos a la habitacion buscada de la BD
		return buscarhab;
	}//fin de metodo buscar habitacion

	
	public void EliminarHabitacion(Habitacion hab) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    Habitacion habitacionToDelete = em.find(Habitacion.class, hab.getID_Habitacion());
	    
	    if (habitacionToDelete != null) {
	        em.remove(habitacionToDelete);
	        System.out.println("Habitacion eliminado de la BD correctamente");
	    } else {
	        System.out.println("No se ha encontrado la habitacion para eliminar");
	    }
	    
	    em.getTransaction().commit();
	    em.close();
		/*
		//Establecemos la conexio�n con la unidad de persistencia.
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectolp");
		//Gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//Iniciamos la transaccion
		emanager.getTransaction().begin(); // BEGIN
		//Recuperamos el código a eliminar
		Habitacion elim = emanager.merge(hab);
		//Procedemos a eliminar
		emanager.remove(elim);
		//Emitimos mensaje por consola
		System.out.println("Habitacion eliminado de la BD");
		//Confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		*/
	}//fin de metodo eliminar habitacion

	
	public List<Habitacion> listaHabitacion() {
		//Establecer la conexión con la undidad de persistencia
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		//Gestionar entidades
		EntityManager emanager = em.createEntityManager();
		//Iniciamos la transaccion
		emanager.getTransaction().begin();
		//Recuperamos el listado de habitaciones de la base de datos
		//aplicacmos consultas JPQL
		List<Habitacion> listadohabitacion = emanager.createQuery("SELECT h FROM Habitacion h JOIN FETCH h.tipohabitacion JOIN FETCH h.estadohabitacion", Habitacion.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//retornamos el listado de habitacion a la BD
		return listadohabitacion;
	}//fin de metodo lista habitacion


	@Override
	public List<Estadohabitacion> listaEstadoHabitacion() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<Estadohabitacion> listadoestadohabitacion = emanager.createQuery("SELECT e FROM Estadohabitacion e", Estadohabitacion.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listadoestadohabitacion;
	}


	@Override
	public List<Tipohabitacion> listaTipoHabitacion() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<Tipohabitacion> listadotipohabitacion = emanager.createQuery("SELECT t FROM Tipohabitacion t", Tipohabitacion.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listadotipohabitacion;
	}


	public Habitacion BuscarHabitacionPorID(int idHabitacion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		EntityManager em = emf.createEntityManager();
	    return em.find(Habitacion.class, idHabitacion);
	}

} //fin de la clase
