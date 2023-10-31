package com.fut5appv2.app.inputOutput.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.fut5appv2.app.bootstrap.constantes.Constantes;
import com.fut5appv2.app.domain.Entrenador;
import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.ArchivosInterface;

public class ArchivosImpl implements ArchivosInterface{
	
	public static Jugador newFileJugador;
	
	public static Equipo newFileEquipo;
	
	public static Entrenador newFileEntrenador;
	
	static Calendar calendar = Calendar.getInstance();

	@Override
	public List<Equipo> cargarEquipoDesdeArchivo(String rutaArchivo){
		List<Equipo> equipos = new ArrayList<>();
		try {
			List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
			for(String linea : lineas) {
				String[] partes = linea.split(";");
				String nombreEquipo = partes[0];
				int date = Integer.parseInt(partes[1]);
				int month = Integer.parseInt(partes[2]);
				int year = Integer.parseInt(partes[3]);
				newFileEntrenador = new Entrenador(partes[4], partes[5], Integer.parseInt(partes[6]));
				newFileEquipo = new Equipo();
				newFileEquipo.setNombre(nombreEquipo);
				calendar.set(year, month, date);
				newFileEquipo.setFechaCreacion(calendar);
				newFileEquipo.setEntrenador(newFileEntrenador);
				equipos.add(newFileEquipo);
			}
		}catch(IOException e) {
			throw new RuntimeException();
		}
		return equipos;
	}

	@Override
	public List<Jugador> cargarJugadorDesdeArchivo(Equipo equipo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Jugador crearJugadorDesdeArchivo(String rutaArchivo) {
		try {
			List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
			for(String linea : lineas) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String apellido = partes[1];
				int posicion = Integer.parseInt(partes[2]);
				int altura = Integer.parseInt(partes[3]);
				int goles = Integer.parseInt(partes[4]);
				int partidos = Integer.parseInt(partes[5]);
				int camiseta = Integer.parseInt(partes[6]);
				
				newFileJugador.setId(UUID.randomUUID());
				newFileJugador.setNombre(nombre);
				newFileJugador.setApellido(apellido);
				newFileJugador.setPosicion(Constantes.POSICIONES[posicion]);
				newFileJugador.setAltura(altura);
				newFileJugador.setGoles(goles);
				newFileJugador.setPartidos(partidos);
				newFileJugador.setCamiseta(camiseta);
			}
		}catch(IOException e) {
			throw new RuntimeException();
		}
		return newFileJugador;
	}

}
