package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_Cliente;

	private String apellidoC;

	private String dni;

	private String email;

	private String nombreC;

	private int telefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;

	public Cliente() {
	}

	public int getID_Cliente() {
		return this.ID_Cliente;
	}

	public void setID_Cliente(int ID_Cliente) {
		this.ID_Cliente = ID_Cliente;
	}

	public String getApellidoC() {
		return this.apellidoC;
	}

	public void setApellidoC(String apellidoC) {
		this.apellidoC = apellidoC;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreC() {
		return this.nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCliente(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCliente(null);

		return reserva;
	}

}