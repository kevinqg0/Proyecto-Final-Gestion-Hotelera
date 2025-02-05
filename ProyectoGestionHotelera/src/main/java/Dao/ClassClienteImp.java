package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ICliente;
import model.Cliente;

public class ClassClienteImp implements ICliente{

	public void RegistrarCliente(Cliente cli) {
		//establecer conexion con la unidad de persistencia...
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        //permite gestionar entidades
        EntityManager em=fabr.createEntityManager();
        //iniciar transaccion
        em.getTransaction().begin();
        //registramos
        em.persist(cli);
        //emitimos mensaje por consola
        System.out.println("cliente registrado en la BD correctamente");
        //confirmamos
        em.getTransaction().commit();
        //cerramos la transaccion
        em.close();
	} //fin de metodo registrar cliente

	public void ActualizarCliente(Cliente cli) {
		//establecer  la conexion con la unidad de persistencia...
        EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
        //gestionar las entidades
        EntityManager emanager= em.createEntityManager();
        //inicar la transaccion
        emanager.getTransaction().begin();
        //Actualizar
        emanager.merge(cli);
        //Emitimos mensaje
        System.out.println("Cliente actualizado correctamente en la BD");
        //confirmamos
        emanager.getTransaction().commit();
        //cerramos
        emanager.close();
	} //fin de metodo actualizar cliente

	
	public Cliente BuscarCliente(Cliente cli) {
		//Establecemos la conexión con la unidad de persistencia...
		EntityManagerFactory fbr = Persistence.createEntityManagerFactory("PoyectoHoteleriaLP2");
		//Gestionar las entidades
		EntityManager emanager = fbr.createEntityManager();
		//Iniciamos la transacción
		emanager.getTransaction().begin();
		//Recuperamos el codigo a buscar...
		Cliente buscarcli = emanager.find(Cliente.class, cli.getID_Cliente());
		//Confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//Retornamos al cliente buscado de la BD
		return buscarcli;
	} //fin de metodo buscar cliente

	
	public void EliminarCliente(Cliente cli) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    // Buscar el cliente por su ID antes de eliminarlo
	    Cliente clienteToDelete = em.find(Cliente.class, cli.getID_Cliente());
	    
	    if (clienteToDelete != null) {
	        em.remove(clienteToDelete);
	        System.out.println("Cliente eliminado de la BD correctamente");
	    } else {
	        System.out.println("No se encontr� el cliente para eliminar");
	    }
	    
	    em.getTransaction().commit();
	    em.close();
	}

	
	public List<Cliente> listaCliente() {
		//Establecer la conexión con la undidad de persistencia
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		//Gestionar entidades
		EntityManager emanager = em.createEntityManager();
		//Iniciamos la transaccion
		emanager.getTransaction().begin();
		//Recuperamos el listado de clientes de la base de datos
		//aplicacmos consultas JPQL
		List<Cliente> listadocliente = emanager.createQuery("select c from Cliente c", Cliente.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//retornamos el listado de clientes a la BD
		return listadocliente;
	} //fin de metodo lista cliente

	
	
	public Cliente BuscarClientePorID(int idCliente) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionHotelera");
		 EntityManager em = emf.createEntityManager();
	     return em.find(Cliente.class, idCliente);
	}

} //fin de la clase
