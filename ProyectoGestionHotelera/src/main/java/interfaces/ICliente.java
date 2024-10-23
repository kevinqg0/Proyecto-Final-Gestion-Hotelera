package interfaces;

import java.util.List;

import model.Cliente;

public interface ICliente {
	public void RegistrarCliente (Cliente cli);
	public void ActualizarCliente (Cliente cli);
	public Cliente BuscarCliente (Cliente cli);
	public void EliminarCliente (Cliente cli);
	public List<Cliente> listaCliente (); //Modificado, no recibe parametros este listado
	
} //fin interface
