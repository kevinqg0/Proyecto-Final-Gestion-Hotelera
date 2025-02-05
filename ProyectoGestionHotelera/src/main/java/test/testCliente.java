package test;

import java.util.List;

import Dao.ClassClienteImp;
import model.Cliente;

public class testCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassClienteImp crud = new ClassClienteImp();
		Cliente cli = new Cliente();

		// 1. Registrar cliente ----------------------------------
/*		cli.setNombreC("prueba");
		cli.setApellidoC("prueba");
		cli.setEmail("jkasjka.@gmail.com");
		cli.setDni("777777");
		cli.setTelefono(999999);

		crud.RegistrarCliente(cli);
*/

		cli.setID_Cliente(7);
		crud.EliminarCliente(cli);

		List<Cliente> listado = crud.listaCliente();

		// Aplicamos bucle for...
		for (Cliente list : listado) {

			// Imprimimos los datos por pantalla
			System.out.println("ID: " + list.getID_Cliente() + "\nNombre: " + list.getNombreC() + "\nApellido: "
					+ list.getApellidoC() + "\nDni: " + list.getDni() + "\nEmail: " + list.getEmail() + "\nTelefono: "
					+ list.getTelefono() + "\nEmail: " + list.getEmail() + "\nDNI: " + list.getDni() + "\nTelefono: "
					+ list.getTelefono()
					+ "\n***************************");
		}
		
	}

}
