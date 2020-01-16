package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

public class ReservarController {
	public ServiceLocator serviceLocator;
	
	public ReservarController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}

	public List<VueloDTO> busquedaWeb(String origen, String destino, Date fechaSalida, Date fechaLlegada, int nPersonas) {
		try {
			return this.serviceLocator.getService().getVuelos();
		} catch (RemoteException e) {
			System.err.println("# Error getting all categories: " + e);
			return null;
		}
	}

	public void reserva(Cliente cliente, String nReserva, Vuelo vuelo, int nPersonas) {
		try {
			
			return this.serviceLocator.getService().reserva(cliente, nReserva, vuelo, nPersonas);
		} catch (RemoteException e) {
			System.err.println("# Error getting articles of a category: " + e);
			return null;
		}
	}
}