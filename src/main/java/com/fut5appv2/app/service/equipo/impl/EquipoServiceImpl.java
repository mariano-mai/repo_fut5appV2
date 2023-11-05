package com.fut5appv2.app.service.equipo.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.fut5appv2.app.domain.Entrenador;
import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.service.entrenador.impl.EntrenadorServiceImpl;
import com.fut5appv2.app.service.equipo.EquipoService;
import com.fut5appv2.app.service.jugador.impl.JugadorServiceImpl;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class EquipoServiceImpl implements EquipoService{
	
	public static EquipoService equipoService = new EquipoServiceImpl();
	
	static Equipo newEquipo;
	
	static Entrenador newEntrenador;
	
	static Jugador newJugador;
	
	public static List<Jugador> listaDeJugadores;

	@Override
	public void agregarJugadores(Equipo equipo) {
		equipo.setListaDeJugadores(generadorDeLista(equipo));
		setteadorDeLista(listaDeJugadores);
	}
	
	@Override
	public void agregarEntrenador(Equipo equipo) {
		equipo.setEntrenador(EntrenadorServiceImpl.entrenadorService.crearEntrenador());
	}
	
	private List<Jugador> generadorDeLista(Equipo equipo){
		listaDeJugadores = new ArrayList<>();
		for(int i=0; i<5; i++) {
			newJugador = new Jugador(equipo);
			newJugador.setId(UUID.randomUUID());
			listaDeJugadores.add(newJugador);
		}
		return listaDeJugadores;
	}
	
	private void setteadorDeLista(List<Jugador> listaDeJugadores) {
		for(Jugador jugador : listaDeJugadores) {
			JugadorServiceImpl.jugadorService.setearJugador(jugador);
		}
		JugadorServiceImpl.esCapitan();
	}
	
	@Override
	public void mostrarJugadores(Equipo equipo) {
		System.out.println("Jugadores: ");
		for(Jugador jugador : equipo.getListaDeJugadores()) {
			System.out.println("- "+jugador.getApellido()+", "+jugador.getNombre()+((jugador.isCapitania())?"(C)":"")+" - "+jugador.getPosicion());
		}
	}
	
	@Override
	public void mostrarEntrenador(Equipo equipo) {
		System.out.println("Entrenador: "+equipo.getEntrenador().getApellido()+", "+equipo.getEntrenador().getNombre());
	}
	
	@Override
	public Equipo crearEquipo(String nombre) {
		newEquipo = new Equipo(nombre);
		newEquipo.setFechaCreacion(fechaDeCreacion());
		return newEquipo;
	}
	
	@Override
	public void mostrarEquipos() {
		if(MapeoServiceImpl.equipoMap.isEmpty()) {
			System.out.println("Aún no hay equipos creados.");
		}else {
			for(Equipo equipo : MapeoServiceImpl.equipoMap.values()) {
				System.out.println("- "+equipo.getNombre()+mostrarFecha(equipo));
			}
		}
	}
	
	private Calendar fechaDeCreacion() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Ingrese Fecha de Creación del Equipo: ");
		System.out.println("Día: ");
		int date = InputScannerImpl.inputTeclado.entradaDeEntero();
		System.out.println("Mes: ");
		int month = InputScannerImpl.inputTeclado.entradaDeEntero();
		System.out.println("Año: ");
		int year = InputScannerImpl.inputTeclado.entradaDeEntero();
		calendar.set(year, month, date);
		return calendar;
	}
	
	private String mostrarFecha(Equipo equipo) {
		String fecha = " - Creado: "+
			equipo.getFechaCreacion().get(Calendar.DATE)+"/"+
			equipo.getFechaCreacion().get(Calendar.MONTH)+"/"+
			equipo.getFechaCreacion().get(Calendar.YEAR);
		return fecha;
	}
	
	public static Equipo crearEquipoV1(String nombre) {
		newEquipo = new Equipo(nombre);
		return newEquipo;
	}

}
