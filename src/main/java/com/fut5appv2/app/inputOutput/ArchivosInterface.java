package com.fut5appv2.app.inputOutput;

public interface ArchivosInterface {
	
	static final String RUTAEQUIPOS = "src/main/java/com/fut5appv2/app/resources/Equipos.txt";
	static final String RUTAJUGADORES = "src/main/java/com/fut5appv2/app/resources/Jugadores.txt";
	
	void cargarEquipoDesdeArchivo(String rutaArchivo);
	
	void cargarJugadorDesdeArchivo();

}
