package com.fut5appv2.app.service.equipo;

import com.fut5appv2.app.domain.Equipo;

public interface EquipoService {
	
	Equipo crearEquipo(String nombre);
	
	void agregarJugadores(Equipo equipo);
	
	void agregarEntrenador(Equipo equipo);
	
	void mostrarEquipos();
	
	void mostrarJugadores(Equipo equipo);
	
	void mostrarEntrenador(Equipo equipo);

}
