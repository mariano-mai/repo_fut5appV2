package com.fut5appv2.app.bootstrap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.fut5appv2.app.bootstrap.constantes.Constantes;
import com.fut5appv2.app.domain.Entrenador;
import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class BootstrapData implements Constantes{
	
	public static Constantes bootStrap = new BootstrapData();
	
	public static List<Jugador> listaDeJugadores;
	
	static Jugador newJugador;

	@Override
	public void BDcrearEquipo() {
		for(int i=0; i<10; i++) {
			MapeoServiceImpl.mapeoService.BDmapeoDeEquipo(Constantes.NOMBRESDEEQUIPO[i]);
		}
	}
	
	@Override
	public void BDsettearEquipo() {
		for(Equipo equipo : MapeoServiceImpl.equipoMap.values()) {
			equipo.setFechaCreacion(setearFecha());
			equipo.setEntrenador(BDcrearEntrenador());
			equipo.setListaDeJugadores(generadorDeLista(equipo));
			setearLista(equipo);
		}
		
	}
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}

	private Calendar setearFecha() {
		Calendar calendar = Calendar.getInstance();
		int year = getRandomNumber(1980, 2023);
		int month = getRandomNumber(1, 12);
		int date = getRandomNumber(1, 31);
		calendar.set(year, month, date);
		return calendar;
	}
	
	private Entrenador BDcrearEntrenador() {
		Entrenador newEntrenador = new Entrenador();
		newEntrenador.setNombre(Constantes.NOMBRES[getRandomNumber(0, 80)]);
		newEntrenador.setApellido(Constantes.APELLIDOS[getRandomNumber(0, 80)]);
		newEntrenador.setEdad(getRandomNumber(45, 70));
		return newEntrenador;
	}
	
	private List<Jugador> generadorDeLista(Equipo equipo){
		listaDeJugadores = new ArrayList<>();
		for(int i=0; i<5; i++) {
			newJugador = new Jugador(equipo);
			listaDeJugadores.add(newJugador);
		}
		return listaDeJugadores;
	}
	
	private void crearJugadorV2(Jugador newJugador) {
		newJugador.setId(UUID.randomUUID());
		newJugador.setNombre(Constantes.NOMBRES[getRandomNumber(0, 80)]);
		newJugador.setApellido(Constantes.APELLIDOS[getRandomNumber(0, 80)]);
		newJugador.setPosicion(Constantes.POSICIONES[getRandomNumber(1, 3)]);
		newJugador.setAltura(getRandomNumber(160, 170));
		newJugador.setGoles(getRandomNumber(0, 15));
		newJugador.setPartidos(getRandomNumber(0, 25));
		newJugador.setCamiseta(getRandomNumber(1, 10));
	}
	
	private void setearLista(Equipo equipo) {
		for(Jugador jugador : equipo.getListaDeJugadores()) {
			crearJugadorV2(jugador);
			MapeoServiceImpl.mapeoService.mapeoDeJugadores(jugador);
		}
		equipo.getListaDeJugadores().get(getRandomNumber(0, 4)).setCapitania(true);
		equipo.getListaDeJugadores().get(getRandomNumber(0, 4)).setPosicion("Arquero");
	}

}
