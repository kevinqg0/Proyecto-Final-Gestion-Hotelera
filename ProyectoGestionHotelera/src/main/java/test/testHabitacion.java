package test;

import Dao.ClassHabitacionImp;

import model.Habitacion;

public class testHabitacion {

	public static void main(String[] args) {
		ClassHabitacionImp crud = new ClassHabitacionImp();
		Habitacion hab = new Habitacion();

		// 1. Registrar cliente ----------------------------------
		hab.setPrecio(40.00);
		hab.setComodidades("WIFI- CABLE");
		hab.setEstadohabitacion(null);
		hab.setTipohabitacion(null);

		crud.RegistrarHabitacion(hab);

	}

}
