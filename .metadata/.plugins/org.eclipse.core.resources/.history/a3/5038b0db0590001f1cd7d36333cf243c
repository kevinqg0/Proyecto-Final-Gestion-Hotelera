package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_USU")
	private int codUsu;

	@Column(name="APE_USU")
	private String apeUsu;

	@Column(name="EST_USU")
	private String estUsu;

	@Column(name="LOG_USU")
	private String logUsu;

	@Column(name="NOM_USU")
	private String nomUsu;

	@Column(name="PAS_USU")
	private String pasUsu;

	//bi-directional many-to-many association to Menu
	@ManyToMany
	@JoinTable(
		name="acceso"
		, joinColumns={
			@JoinColumn(name="COD_USU")
			}
		, inverseJoinColumns={
			@JoinColumn(name="COD_MENU")
			}
		)
	private List<Menu> menus;

	public Usuario() {
	}

	public int getCodUsu() {
		return this.codUsu;
	}

	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}

	public String getApeUsu() {
		return this.apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public String getEstUsu() {
		return this.estUsu;
	}

	public void setEstUsu(String estUsu) {
		this.estUsu = estUsu;
	}

	public String getLogUsu() {
		return this.logUsu;
	}

	public void setLogUsu(String logUsu) {
		this.logUsu = logUsu;
	}

	public String getNomUsu() {
		return this.nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getPasUsu() {
		return this.pasUsu;
	}

	public void setPasUsu(String pasUsu) {
		this.pasUsu = pasUsu;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}