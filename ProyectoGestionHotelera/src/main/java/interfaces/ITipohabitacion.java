package interfaces;

import java.util.List;

import model.Tipohabitacion;

public interface ITipohabitacion {
	
	public List<Tipohabitacion> listaTipoHabitacion();
	public Tipohabitacion findTipohabitacionById(int id);
} 
