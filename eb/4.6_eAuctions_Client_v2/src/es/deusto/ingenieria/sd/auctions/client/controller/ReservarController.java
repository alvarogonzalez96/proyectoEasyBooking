package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

public class ReservarController {
	public ServiceLocator serviceLocator;
	
	public ReservarController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}

	public List<VueloDTO> busquedaWeb(String origen, String destino, Date fechaSalida, Date fechaLlegada, int nPersonas) {
		try {
			/*
			Como funciona lo de service locator? Habrá que devolver según los parámetros de búsqueda
			*/
			return this.serviceLocator.getService().getCategories();
		} catch (RemoteException e) {
			System.err.println("# Error getting all categories: " + e);
			return null;
		}
	}

	public void reserva(String nVuelo, Date fechaSalida, int nPersonas) {
		try {
			/*
			Más de lo mismo
			*/
			return this.serviceLocator.getService().getArticles(category);
		} catch (RemoteException e) {
			System.err.println("# Error getting articles of a category: " + e);
			return null;
		}
	}
}