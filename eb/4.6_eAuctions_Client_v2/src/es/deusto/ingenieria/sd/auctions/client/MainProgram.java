package es.deusto.ingenieria.sd.auctions.client;

import es.deusto.ingenieria.sd.auctions.client.controller.ReservarController;
import es.deusto.ingenieria.sd.auctions.client.controller.SesionController;
import es.deusto.ingenieria.sd.auctions.client.gui.ReservaWindow;
import es.deusto.ingenieria.sd.auctions.client.gui.RegistryDialog;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		SesionController sesionController = new SesionController(serviceLocator);
		RegistryDialog registryDialog = new RegistryDialog(sesionController);			
		loginDialog.login();
		
		ReservaController reservaController = new BidController(serviceLocator);			
		ReservaWindow reservaWindow = new BidWindow(reservaController);
		reservaWindow.busquedaWeb();
		reservaWindow.reserva();		
	}
}
