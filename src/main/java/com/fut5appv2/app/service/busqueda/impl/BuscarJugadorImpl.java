package com.fut5appv2.app.service.busqueda.impl;

import com.fut5appv2.app.service.busqueda.BuscarJugador;
import com.fut5appv2.app.service.complementos.impl.FuncionesComplementariasImpl;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class BuscarJugadorImpl implements BuscarJugador{
	
	public static BuscarJugador buscar = new BuscarJugadorImpl();

	@Override
	public void buscarPorNombre(String nombre, String apellido) {
		String clave = FuncionesComplementariasImpl.funcCompl.formadorDeClave(nombre, apellido);
		if(MapeoServiceImpl.jugadoresMap.containsKey(clave)) {
			System.out.println("<<INFORMACIÓN SOLICITADA>>");
			informacion(clave);
		}else {
			System.out.println("El Jugador "+clave+", no existe. Pruebe de nuevo.");
		}
		
	}
	
	private void informacion(String clave) {
		System.out.println("NOMBRE: "+MapeoServiceImpl.jugadoresMap.get(clave).getNombre()+"\n"
				+ "APELLIDO: "+MapeoServiceImpl.jugadoresMap.get(clave).getApellido()+"\n"
				+ "POSICIÓN: "+MapeoServiceImpl.jugadoresMap.get(clave).getPosicion()+"\n"
				+(MapeoServiceImpl.jugadoresMap.get(clave).isCapitania()?"Es el Capitán":"No es el Capitán")+"\n"
				+ "EQUIPO: "+MapeoServiceImpl.jugadoresMap.get(clave).getEquipo().getNombre());
	}

}
