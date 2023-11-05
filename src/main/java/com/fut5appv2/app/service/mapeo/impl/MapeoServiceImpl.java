package com.fut5appv2.app.service.mapeo.impl;

import java.util.HashMap;
import java.util.Map;

import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.service.complementos.impl.FuncionesComplementariasImpl;
import com.fut5appv2.app.service.equipo.impl.EquipoServiceImpl;
import com.fut5appv2.app.service.mapeo.MapeoService;

public class MapeoServiceImpl implements MapeoService{
	
	public static MapeoService mapeoService = new MapeoServiceImpl();
	
	public static Map<String, Equipo> equipoMap = new HashMap<>();
	
	public static Map<String, Jugador> jugadoresMap = new HashMap<>();

	@Override
	public void mapeoDeEquipo(String nombreEquipo) {
		equipoMap.put(nombreEquipo, EquipoServiceImpl.equipoService.crearEquipo(nombreEquipo));
	}
	
	@Override
	public void BDmapeoDeEquipo(String nombre) {
		equipoMap.put(nombre, EquipoServiceImpl.crearEquipoV1(nombre));
	}

	@Override
	public void mapeoDeJugadores(Jugador jugador) {
		jugadoresMap.put(FuncionesComplementariasImpl.funcCompl.formadorDeClave(jugador.getNombre(), jugador.getApellido()), jugador);
	}

}
