package com.fut5appv2.app;

import com.fut5appv2.app.bootstrap.BootstrapData;
import com.fut5appv2.app.service.execution.impl.EjecucionImpl;

public class App 
{
    public static void main( String[] args )
    {
    	BootstrapData.bootStrap.BDcrearEquipo();
    	BootstrapData.bootStrap.BDsettearEquipo();
        EjecucionImpl.ejecutar.ejecutar();
    }
}
