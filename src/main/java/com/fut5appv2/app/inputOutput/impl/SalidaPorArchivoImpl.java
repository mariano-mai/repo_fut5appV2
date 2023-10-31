package com.fut5appv2.app.inputOutput.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.SalidaPorArchivo;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class SalidaPorArchivoImpl implements SalidaPorArchivo{
	
	public static SalidaPorArchivo salidaArchivo = new SalidaPorArchivoImpl();

	@Override
	public void listaDeEquipos(File rutaDestino) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDestino))){
			for(Equipo equipo : MapeoServiceImpl.equipoMap.values()) {
				String linea = equipo.getNombre()+";"+
			equipo.getFechaCreacion().get(Calendar.DATE)+";"+
			equipo.getFechaCreacion().get(Calendar.MONTH)+";"+
			equipo.getFechaCreacion().get(Calendar.YEAR)+";"+
			equipo.getEntrenador().getNombre()+";"+
			equipo.getEntrenador().getApellido()+";"+
			equipo.getEntrenador().getEdad();
				writer.write(linea);
				writer.newLine();
			}
		}catch(IOException e) {
			new RuntimeException();
		}
		
	}

	@Override
	public void listaDeJugadores(File rutaDestino) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDestino))){
			for(Jugador jugador : MapeoServiceImpl.jugadoresMap.values()) {
				String linea = jugador.getNombre()+";"+
			jugador.getApellido()+";"+
			jugador.getPosicion()+";"+
			jugador.getAltura()+";"+
			jugador.getGoles()+";"+
			jugador.getPartidos()+";"+
			jugador.getCamiseta()+";"+
			(jugador.isCapitania()? "capitán":"")+";"+
			jugador.getEquipo().getNombre();
				writer.write(linea);
				writer.newLine();
			}
		}catch(IOException e) {
			new RuntimeException();
		}
		
	}

}
