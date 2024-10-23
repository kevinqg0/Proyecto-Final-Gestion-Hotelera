package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the habitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Habitacion.findAll", query="SELECT h FROM Habitacion h")
public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_Habitacion;

	private String comodidades;

	private double precio;

	//bi-directional many-to-one association to Tipohabitacion
	@ManyToOne
	@JoinColumn(name="ID_TipoH")
	private Tipohabitacion tipohabitacion;

	//bi-directional many-to-one association to Estadohabitacion
	@ManyToOne
	@JoinColumn(name="ID_EstadoH")
	private Estadohabitacion estadohabitacion;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="habitacion")
	private List<Reserva> reservas;

	public Habitacion() {
	}

	public int getID_Habitacion() {
		return this.ID_Habitacion;
	}

	public void setID_Habitacion(int ID_Habitacion) {
		this.ID_Habitacion = ID_Habitacion;
	}

	public String getComodidades() {
		return this.comodidades;
	}

	public void setComodidades(String comodidades) {
		this.comodidades = comodidades;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Tipohabitacion getTipohabitacion() {
		return this.tipohabitacion;
	}

	public void setTipohabitacion(Tipohabitacion tipohabitacion) {
		this.tipohabitacion = tipohabitacion;
	}

	public Estadohabitacion getEstadohabitacion() {
		return this.estadohabitacion;
	}

	public void setEstadohabitacion(Estadohabitacion estadohabitacion) {
		this.estadohabitacion = estadohabitacion;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHabitacion(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHabitacion(null);

		return reserva;
	}

}