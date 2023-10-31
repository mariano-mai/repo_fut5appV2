package com.fut5appv2.app;

import com.fut5appv2.app.inputOutput.ArchivosInterface;
import com.fut5appv2.app.inputOutput.impl.ArchivosImpl;
import com.fut5appv2.app.service.execution.impl.EjecucionImpl;

public class App 
{
    public static void main( String[] args )
    {
    	ArchivosImpl.entradaArchivos.cargarEquipoDesdeArchivo(ArchivosInterface.RUTAEQUIPOS);
    	ArchivosImpl.entradaArchivos.cargarJugadorDesdeArchivo();
        EjecucionImpl.ejecutar.ejecutar();
    }
}
