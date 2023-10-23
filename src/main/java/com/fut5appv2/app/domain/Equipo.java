package com.fut5appv2.app.domain;

import java.util.Calendar;
import java.util.List;

public class Equipo {
	
	private String nombre;
	private Calendar fechaCreacion;
	private List<Jugador> listaDeJugadores;
	private Entrenador entrenador;
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Equipo(String nombre, Calendar fechaCreacion, List<Jugador> listaDeJugadores, Entrenador entrenador) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.listaDeJugadores = listaDeJugadores;
		this.entrenador = entrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Jugador> getListaDeJugadores() {
		return listaDeJugadores;
	}

	public void setListaDeJugadores(List<Jugador> listaDeJugadores) {
		this.listaDeJugadores = listaDeJugadores;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

}
