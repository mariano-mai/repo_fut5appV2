package com.fut5appv2.app.service.eliminacion.impl;

import com.fut5appv2.app.service.eliminacion.EliminarInterface;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class EliminarImpl implements EliminarInterface{
	
	public static EliminarInterface removerEquipo = new EliminarImpl();

	@Override
	public void eliminarEquipo(String nombre) {
		if(MapeoServiceImpl.equipoMap.containsKey(nombre)) {
			MapeoServiceImpl.equipoMap.remove(nombre);
			System.out.println("Equipo eliminado con éxito.");
		}else {
			System.out.println("El equipo "+nombre+" no existe. Intente de nuevo.");
		}
	}

}
