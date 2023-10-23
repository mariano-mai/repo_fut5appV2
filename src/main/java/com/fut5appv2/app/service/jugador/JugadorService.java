package com.fut5appv2.app.service.jugador;

import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;

public interface JugadorService {
	
	Jugador crearJugador();
	
	Jugador crearJugadorV2(Equipo equipo);
	
	void setearJugador(Jugador jugador);

}
