package com.fut5appv2.app.service.entrenador.impl;

import com.fut5appv2.app.domain.Entrenador;
import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.service.entrenador.EntrenadorInterface;

public class EntrenadorServiceImpl implements EntrenadorInterface{
	
	public static EntrenadorInterface entrenadorService = new EntrenadorServiceImpl();
	
	static Entrenador newEntrenador;

	@Override
	public Entrenador crearEntrenador() {
		newEntrenador = new Entrenador();
		System.out.println("Ingrese nombre del Entrenador: ");
		newEntrenador.setNombre(InputScannerImpl.inputTeclado.entradaDeTexto());
		System.out.println("Ingrese apellido del Entrenador: ");
		newEntrenador.setApellido(InputScannerImpl.inputTeclado.entradaDeTexto());
		System.out.println("Ingrese edad del Entrenador: ");
		newEntrenador.setEdad(InputScannerImpl.inputTeclado.entradaDeEntero());
		return newEntrenador;
	}

}
