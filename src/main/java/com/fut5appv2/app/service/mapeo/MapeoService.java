package com.fut5appv2.app.service.mapeo;

import com.fut5appv2.app.domain.Jugador;

public interface MapeoService {
	
	void mapeoDeEquipo(String nombreEquipo);
	
	void BDmapeoDeEquipo(String nombre);
	
	void mapeoDeJugadores(Jugador jugador);

}
