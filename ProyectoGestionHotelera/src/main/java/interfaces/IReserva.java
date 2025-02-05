package interfaces;

import java.util.List;
import model.Reserva;

public interface IReserva {
	public void RegistrarReserva (Reserva re);
	public void ActualizarReserva (Reserva re);
	public Reserva BuscarReserva (Reserva re);
	public void EliminarReserva (Reserva re);
	public List<Reserva> listaReserva ();
	
} //fin de la interface 
