package com.fut5appv2.app.service.execution.impl;

import com.fut5appv2.app.menu.impl.MenuServiceImpl;
import com.fut5appv2.app.service.execution.Ejecucion;

public class EjecucionImpl implements Ejecucion{
	
	public static Ejecucion ejecutar = new EjecucionImpl();

	@Override
	public void ejecutar() {
		MenuServiceImpl.menuOpciones.menuDeOpciones();	
	}

	@Override
	public void finalizarPrograma() {
		System.out.println("Gracias por utilizar fut5appV2. Que tenga una buena jornada.");
	}

}
