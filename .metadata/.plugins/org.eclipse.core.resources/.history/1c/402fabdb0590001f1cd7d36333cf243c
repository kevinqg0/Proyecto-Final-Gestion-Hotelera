package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipohabitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Tipohabitacion.findAll", query="SELECT t FROM Tipohabitacion t")
public class Tipohabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_TipoH;

	private String nom_TipoH;

	//bi-directional many-to-one association to Habitacion
	@OneToMany(mappedBy="tipohabitacion")
	private List<Habitacion> habitacions;

	public Tipohabitacion() {
	}

	public int getID_TipoH() {
		return this.ID_TipoH;
	}

	public void setID_TipoH(int ID_TipoH) {
		this.ID_TipoH = ID_TipoH;
	}

	public String getNom_TipoH() {
		return this.nom_TipoH;
	}

	public void setNom_TipoH(String nom_TipoH) {
		this.nom_TipoH = nom_TipoH;
	}

	public List<Habitacion> getHabitacions() {
		return this.habitacions;
	}

	public void setHabitacions(List<Habitacion> habitacions) {
		this.habitacions = habitacions;
	}

	public Habitacion addHabitacion(Habitacion habitacion) {
		getHabitacions().add(habitacion);
		habitacion.setTipohabitacion(this);

		return habitacion;
	}

	public Habitacion removeHabitacion(Habitacion habitacion) {
		getHabitacions().remove(habitacion);
		habitacion.setTipohabitacion(null);

		return habitacion;
	}

}