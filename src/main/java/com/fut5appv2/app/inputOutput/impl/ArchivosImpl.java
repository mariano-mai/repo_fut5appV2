package com.fut5appv2.app.inputOutput.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.fut5appv2.app.domain.Entrenador;
import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.ArchivosInterface;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class ArchivosImpl implements ArchivosInterface{
	
	public static ArchivosInterface entradaArchivos = new ArchivosImpl();
	
	public static Jugador newFileJugador;
	
	public static Equipo newFileEquipo;
	
	public static Entrenador newFileEntrenador;
	
	static Calendar calendar;

	@Override
	public void cargarEquipoDesdeArchivo(String rutaArchivo){
		
		try {
			List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
			for(String linea : lineas) {
				String[] partes = linea.split(";");
				String nombreEquipo = partes[0];
				int date = Integer.parseInt(partes[1]);
				int month = Integer.parseInt(partes[2]);
				int year = Integer.parseInt(partes[3]);
				newFileEntrenador = new Entrenador(partes[4], partes[5], Integer.parseInt(partes[6]));
				calendar = Calendar.getInstance();
				newFileEquipo = new Equipo();
				newFileEquipo.setNombre(nombreEquipo);
				calendar.set(year, month, date);
				newFileEquipo.setFechaCreacion(calendar);
				newFileEquipo.setEntrenador(newFileEntrenador);
				MapeoServiceImpl.equipoMap.put(nombreEquipo, newFileEquipo);
			}
		}catch(IOException e) {
			throw new RuntimeException();
		}
	}

	private void generadorDeLista(Equipo equipo) {
		String nombreEquipo = equipo.getNombre();
		List<Jugador> listaJugadores = new ArrayList<>();
		for(Jugador jugador : MapeoServiceImpl.jugadoresMap.values()) {
			if(jugador.getEquipo().getNombre().equalsIgnoreCase(nombreEquipo)) {
				listaJugadores.add(jugador);
			}
		}
		equipo.setListaDeJugadores(listaJugadores);
	}
	
	private Jugador crearJugadorDesdeArchivo(String rutaArchivo) {
		try {
			List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
			for(String linea : lineas) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String apellido = partes[1];
				String posicion = partes[2];
				int altura = Integer.parseInt(partes[3]);
				int goles = Integer.parseInt(partes[4]);
				int partidos = Integer.parseInt(partes[5]);
				int camiseta = Integer.parseInt(partes[6]);
				boolean capitania = (partes[7].equalsIgnoreCase("capitán"))?true:false;
				Equipo equipo = MapeoServiceImpl.equipoMap.get(partes[8]);
				
				newFileJugador = new Jugador();
				newFileJugador.setId(UUID.randomUUID());
				newFileJugador.setNombre(nombre);
				newFileJugador.setApellido(apellido);
				newFileJugador.setPosicion(posicion);
				newFileJugador.setAltura(altura);
				newFileJugador.setGoles(goles);
				newFileJugador.setPartidos(partidos);
				newFileJugador.setCamiseta(camiseta);
				newFileJugador.setCapitania(capitania);
				newFileJugador.setEquipo(equipo);
				MapeoServiceImpl.mapeoService.mapeoDeJugadores(newFileJugador);
			}
		}catch(IOException e) {
			throw new RuntimeException();
		}
		return newFileJugador;
	}

	@Override
	public void cargarJugadorDesdeArchivo() {
		crearJugadorDesdeArchivo(RUTAJUGADORES);
		for(Equipo equipo : MapeoServiceImpl.equipoMap.values()) {
			generadorDeLista(equipo);
		}
		
	}

}
