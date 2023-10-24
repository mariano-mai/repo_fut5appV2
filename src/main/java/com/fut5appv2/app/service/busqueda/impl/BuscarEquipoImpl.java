package com.fut5appv2.app.service.busqueda.impl;

import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.service.busqueda.BuscarEquipo;
import com.fut5appv2.app.service.equipo.impl.EquipoServiceImpl;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class BuscarEquipoImpl implements BuscarEquipo{
	
	public static BuscarEquipo buscar = new BuscarEquipoImpl();

	@Override
	public void buscarPorNombre(String nombre) {
		if(MapeoServiceImpl.equipoMap.containsKey(nombre)) {
			System.out.println("¿Qué información desea?");
			System.out.println("\t1- Nombre el Equipo, Entrenador, Capitán.\n"
					+ "\t2- Nombre del Equipo, Entrenador, Jugadores.");
			int opcion = InputScannerImpl.inputTeclado.entradaDeEntero();
			switch(opcion) {
			case 1:
				informacion1(nombre);
				break;
			case 2:
				informacion2(nombre);
				break;
			}
		
		}else {
			System.out.println("El Equipo "+nombre+" no existe. Pruebe de nuevo.");
		}
		
	}
	
	private void informacion1(String nombre) {
		System.out.println("Nombre Del Equipo: "+MapeoServiceImpl.equipoMap.get(nombre).getNombre());
		EquipoServiceImpl.equipoService.mostrarEntrenador(MapeoServiceImpl.equipoMap.get(nombre));
		System.out.println("Capitán: "+nombreCapitan(nombre));
	}
	
	private void informacion2(String nombre) {
		System.out.println("Nombre Del Equipo: "+MapeoServiceImpl.equipoMap.get(nombre).getNombre());
		EquipoServiceImpl.equipoService.mostrarEntrenador(MapeoServiceImpl.equipoMap.get(nombre));
		EquipoServiceImpl.equipoService.mostrarJugadores(MapeoServiceImpl.equipoMap.get(nombre));
	}
	
	private String nombreCapitan(String nombre) {
		String nombreDeCapitan = "";
		for(Jugador jugador : MapeoServiceImpl.equipoMap.get(nombre).getListaDeJugadores()) {
			nombreDeCapitan = nombreDeCapitan + ((jugador.isCapitania())?jugador.getApellido()+", "+jugador.getNombre():"");
		}
		return nombreDeCapitan;
	}

}
