package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadohabitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Estadohabitacion.findAll", query="SELECT e FROM Estadohabitacion e")
public class Estadohabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_EstadoH;

	private String nom_EstadoH;

	//bi-directional many-to-one association to Habitacion
	@OneToMany(mappedBy="estadohabitacion")
	private List<Habitacion> habitacions;

	public Estadohabitacion() {
	}

	public int getID_EstadoH() {
		return this.ID_EstadoH;
	}

	public void setID_EstadoH(int ID_EstadoH) {
		this.ID_EstadoH = ID_EstadoH;
	}

	public String getNom_EstadoH() {
		return this.nom_EstadoH;
	}

	public void setNom_EstadoH(String nom_EstadoH) {
		this.nom_EstadoH = nom_EstadoH;
	}

	public List<Habitacion> getHabitacions() {
		return this.habitacions;
	}

	public void setHabitacions(List<Habitacion> habitacions) {
		this.habitacions = habitacions;
	}

	public Habitacion addHabitacion(Habitacion habitacion) {
		getHabitacions().add(habitacion);
		habitacion.setEstadohabitacion(this);

		return habitacion;
	}

	public Habitacion removeHabitacion(Habitacion habitacion) {
		getHabitacions().remove(habitacion);
		habitacion.setEstadohabitacion(null);

		return habitacion;
	}

}