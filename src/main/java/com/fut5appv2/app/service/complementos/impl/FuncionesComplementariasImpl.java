package com.fut5appv2.app.service.complementos.impl;

import com.fut5appv2.app.service.complementos.FuncionesComplementarias;

public class FuncionesComplementariasImpl implements FuncionesComplementarias{
	
	public static FuncionesComplementarias funcCompl = new FuncionesComplementariasImpl();

	@Override
	public String formadorDeClave(String nombre, String apellido) {
		String clave = nombre + " " + apellido;
		return clave;
	}

}
