package com.fut5appv2.app.inputOutput;

import java.util.List;

import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;

public interface ArchivosInterface {
	
	List<Equipo> cargarEquipoDesdeArchivo(String rutaArchivo);
	
	List<Jugador> cargarJugadorDesdeArchivo(Equipo equipo);

}
