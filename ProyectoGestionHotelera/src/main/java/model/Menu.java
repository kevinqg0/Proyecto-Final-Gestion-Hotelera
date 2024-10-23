package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_MEN")
	private int codMen;

	@Column(name="DES_MEN")
	private String desMen;

	@Column(name="URL_MEN")
	private String urlMen;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="menus")
	private List<Usuario> usuarios;

	public Menu() {
	}

	public int getCodMen() {
		return this.codMen;
	}

	public void setCodMen(int codMen) {
		this.codMen = codMen;
	}

	public String getDesMen() {
		return this.desMen;
	}

	public void setDesMen(String desMen) {
		this.desMen = desMen;
	}

	public String getUrlMen() {
		return this.urlMen;
	}

	public void setUrlMen(String urlMen) {
		this.urlMen = urlMen;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}