package com.fut5appv2.app.menu.impl;

import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.menu.MenuInterface;
import com.fut5appv2.app.menu.Retornar;
import com.fut5appv2.app.service.equipo.impl.EquipoServiceImpl;
import com.fut5appv2.app.service.execution.impl.EjecucionImpl;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class MenuServiceImpl implements MenuInterface{
	
	public static MenuInterface menuOpciones = new MenuServiceImpl();
	
	static int opcion;

	@Override
	public void menuDeOpciones() {
		System.out.println("\t<<BIENVENIDO AL MENÚ>>\n");
		
		System.out.println("Ingrese una opción");
		System.out.println("\t0- SALIR DEL PROGRAMA\n"
				+ "\t1- CREAR EQUIPO\n"
				+ "\t2- MOSTRAR EQUIPOS\n"
				+ "\t3- AGREGAR JUGADORES\n"
				+ "\t4- AGREGAR ENTRENADOR\n"
				+ "\t5- MOSTRAR JUGADORES Y ENTRENADOR DE UN EQUIPO");
		
		opcion = InputScannerImpl.inputTeclado.entradaDeEntero();
		
		switch(opcion) {
		case 0:
			EjecucionImpl.ejecutar.finalizarPrograma();
			break;
		case 1:
			System.out.println("Ingrese Nombre del Equipo: ");
			String nombre = InputScannerImpl.inputTeclado.entradaDeTexto();
			MapeoServiceImpl.mapeoService.mapeoDeEquipo(nombre);
			Retornar.volverAlMenu();
			break;
		case 2:
			EquipoServiceImpl.equipoService.mostrarEquipos();
			Retornar.volverAlMenu();
			break;
		case 3:
			System.out.println("Ingrese Nombre del Equipo: ");
			String nombreEquipo = InputScannerImpl.inputTeclado.entradaDeTexto();
			EquipoServiceImpl.equipoService.agregarJugadores(MapeoServiceImpl.equipoMap.get(nombreEquipo));
			
			Retornar.volverAlMenu();
			break;
		case 4:
			System.out.println("Ingrese Nombre del Equipo: ");
			String nombreEquipo2 = InputScannerImpl.inputTeclado.entradaDeTexto();
			EquipoServiceImpl.equipoService.agregarEntrenador(MapeoServiceImpl.equipoMap.get(nombreEquipo2));
			Retornar.volverAlMenu();
			break;
		case 5:
			System.out.println("Ingrese Nombre del Equipo: ");
			String nombreEquipo3 = InputScannerImpl.inputTeclado.entradaDeTexto();
			EquipoServiceImpl.equipoService.mostrarJugadores(MapeoServiceImpl.equipoMap.get(nombreEquipo3));
			EquipoServiceImpl.equipoService.mostrarEntrenador(MapeoServiceImpl.equipoMap.get(nombreEquipo3));
			Retornar.volverAlMenu();
			break;
		case 6:
			menuDeBusqueda();
			Retornar.volverAlMenu();
			break;
		}
	}

	@Override
	public void menuDeBusqueda() {
		System.out.println("\t<<MENÚ DE BÚSQUEDA>>\n");
		
	}

}
