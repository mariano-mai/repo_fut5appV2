package com.fut5appv2.app.inputOutput.impl;

import java.util.Scanner;

import com.fut5appv2.app.inputOutput.InputScanner;

public class InputScannerImpl implements InputScanner{
	
	public static InputScanner inputTeclado = new InputScannerImpl();
	
	static Scanner entrada;

	@Override
	public String entradaDeTexto() {
		entrada = new Scanner(System.in);
		String texto = entrada.nextLine();
		return texto;
	}

	@Override
	public int entradaDeEntero() {
		entrada = new Scanner(System.in);
		int numero = entrada.nextInt();
		return numero;
	}

}
