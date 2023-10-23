package com.fut5appv2.app.service.jugador.impl;

import java.util.UUID;

import com.fut5appv2.app.domain.Equipo;
import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.service.equipo.impl.EquipoServiceImpl;
import com.fut5appv2.app.service.jugador.JugadorService;

public class JugadorServiceImpl implements JugadorService{
	
	public static JugadorService jugadorService = new JugadorServiceImpl();
	
	static Jugador jugador;

	@Override
	public Jugador crearJugador() {
		jugador = new Jugador();
		jugador.setId(UUID.randomUUID());
		System.out.println("Ingrese nombre del Jugador: ");
		jugador.setNombre(InputScannerImpl.inputTeclado.entradaDeTexto());
		System.out.println("Ingrese apellido del Jugador: ");
		jugador.setApellido(InputScannerImpl.inputTeclado.entradaDeTexto());
		return jugador;
	}

	@Override
	public Jugador crearJugadorV2(Equipo equipo) {
		jugador = new Jugador(equipo);
		jugador.setId(UUID.randomUUID());
		System.out.println("Ingrese nombre del Jugador: ");
		jugador.setNombre(InputScannerImpl.inputTeclado.entradaDeTexto());
		System.out.println("Ingrese apellido del Jugador: ");
		jugador.setApellido(InputScannerImpl.inputTeclado.entradaDeTexto());
		darPosicion(jugador);
		//informacionNumerica(jugador);
		return jugador;
	}
	
	@Override
	public void setearJugador(Jugador jugador) {
		System.out.println("Ingrese nombre del Jugador: ");
		jugador.setNombre(InputScannerImpl.inputTeclado.entradaDeTexto());
		System.out.println("Ingrese apellido del Jugador: ");
		jugador.setApellido(InputScannerImpl.inputTeclado.entradaDeTexto());
		darPosicion(jugador);
		//informacionNumerica(jugador);
	}
	
	private void darPosicion(Jugador jugador) {
		System.out.println("Elija la Posición del Jugador: ");
		System.out.println("\t1- ARQUERO\n\t2- DEFENSOR\n\t3- MEDIOCAMPISTA\n\t4- DELANTERO");
		int opcion = InputScannerImpl.inputTeclado.entradaDeEntero();
		switch(opcion) {
		case 1:
			jugador.setPosicion("Arquero");
			break;
		case 2:
			jugador.setPosicion("Defensor");
			break;
		case 3:
			jugador.setPosicion("Mediocampista");
			break;
		case 4:
			jugador.setPosicion("Delantero");
		}
	}
	
	private void informacionNumerica(Jugador jugador) {
		System.out.println("Ingrese Altura en cm: ");
		int altura = InputScannerImpl.inputTeclado.entradaDeEntero();
		jugador.setAltura(altura);
		System.out.println("Ingrese Número de Camiseta: ");
		int camiseta = InputScannerImpl.inputTeclado.entradaDeEntero();
		jugador.setCamiseta(camiseta);
		System.out.println("Ingrese Cantidad de Goles: ");
		int goles = InputScannerImpl.inputTeclado.entradaDeEntero();
		jugador.setGoles(goles);
		System.out.println("Ingrese Cantidad de Partidos Jugados: ");
		int partidos = InputScannerImpl.inputTeclado.entradaDeEntero();
		jugador.setPartidos(partidos);
	}

	public static void esCapitan() {
		int i = 0;
		System.out.println("Seleccione al Capitán del Equipo: ");
		for(Jugador jugador : EquipoServiceImpl.listaDeJugadores) {
			System.out.println((i+1)+"- "+jugador.getNombre()+" "+jugador.getApellido());
			i++;
		}
		int opcion = InputScannerImpl.inputTeclado.entradaDeEntero();
		EquipoServiceImpl.listaDeJugadores.get(opcion-1).setCapitania(true);
	}

}
