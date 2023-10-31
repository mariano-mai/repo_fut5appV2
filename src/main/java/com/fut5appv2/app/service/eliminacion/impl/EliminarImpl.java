package com.fut5appv2.app.service.eliminacion.impl;

import com.fut5appv2.app.domain.Jugador;
import com.fut5appv2.app.service.complementos.impl.FuncionesComplementariasImpl;
import com.fut5appv2.app.service.eliminacion.EliminarInterface;
import com.fut5appv2.app.service.mapeo.impl.MapeoServiceImpl;

public class EliminarImpl implements EliminarInterface{
	
	public static EliminarInterface removerEquipo = new EliminarImpl();

	@Override
	public void eliminarEquipo(String nombre) {
		if(MapeoServiceImpl.equipoMap.containsKey(nombre)) {
			for(Jugador jugador : MapeoServiceImpl.equipoMap.get(nombre).getListaDeJugadores()) {
				eliminarJugadores(jugador.getNombre(), jugador.getApellido());
			}
			MapeoServiceImpl.equipoMap.remove(nombre);
			System.out.println("Equipo eliminado con éxito.");
		}else {
			System.out.println("El equipo "+nombre+" no existe. Intente de nuevo.");
		}
	}
	
	private void eliminarJugadores(String nombre, String apellido) {
		String clave = FuncionesComplementariasImpl.funcCompl.formadorDeClave(nombre, apellido);
		if(MapeoServiceImpl.jugadoresMap.containsKey(clave)) {
			MapeoServiceImpl.jugadoresMap.remove(clave);
		}else {
			System.out.println("El jugador buscado no se encuentra en este equipo.");
		}
	}

}
