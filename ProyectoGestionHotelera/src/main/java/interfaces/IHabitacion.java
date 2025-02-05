package interfaces;

import java.util.List;

import model.Estadohabitacion;
import model.Habitacion;
import model.Tipohabitacion;

public interface IHabitacion {
	public void RegistrarHabitacion (Habitacion hab);
	public void ActualizarHabitacion (Habitacion hab);
	public Habitacion BuscarHabitacion (Habitacion hab);
	public void EliminarHabitacion (Habitacion hab);
	public List<Habitacion> listaHabitacion ();
	
	public List<Estadohabitacion> listaEstadoHabitacion();
	public List<Tipohabitacion> listaTipoHabitacion();
	
} //fin interface
