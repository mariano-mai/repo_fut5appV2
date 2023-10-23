package com.fut5appv2.app.domain;

import java.util.UUID;

public class Jugador {
	
	private String nombre, apellido, posicion;
	private UUID id;
	private int altura, goles, partidos, camiseta;
	private boolean capitania = false;
	private Equipo equipo;
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Jugador(Equipo equipo) {
		super();
		this.equipo = equipo;
	}

	public Jugador(String nombre, String apellido, String posicion, UUID id, int altura, int goles, int partidos,
			int camiseta, boolean capitania, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.id = id;
		this.altura = altura;
		this.goles = goles;
		this.partidos = partidos;
		this.camiseta = camiseta;
		this.capitania = capitania;
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getPartidos() {
		return partidos;
	}

	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}

	public int getCamiseta() {
		return camiseta;
	}

	public void setCamiseta(int camiseta) {
		this.camiseta = camiseta;
	}

	public boolean isCapitania() {
		return capitania;
	}

	public void setCapitania(boolean capitania) {
		this.capitania = capitania;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
