package com.fut5appv2.app.menu;

import com.fut5appv2.app.inputOutput.impl.InputScannerImpl;
import com.fut5appv2.app.menu.impl.MenuServiceImpl;

public class Retornar {
	
	static int opcion;
	
	public static void volverAlMenu() {
		
		System.out.println("\n¿DESEA VOLVER AL MENÚ PRINCIPAL?\n1- SÍ");
		opcion = InputScannerImpl.inputTeclado.entradaDeEntero();
		
		switch(opcion) {
		case 1:
			MenuServiceImpl.menuOpciones.menuDeOpciones();
			break;
		}
	}
	
	public static void volverAlMenuV2() {
		MenuServiceImpl.menuOpciones.menuDeOpciones();
	}

}
