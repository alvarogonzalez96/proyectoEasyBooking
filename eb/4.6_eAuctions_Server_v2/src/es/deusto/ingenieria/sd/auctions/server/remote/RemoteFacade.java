package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.services.BidService;
import es.deusto.ingenieria.sd.auctions.server.services.EntityDataService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;
	public User state;

	private RemoteFacade() throws RemoteException {
		super();		
	}
	
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	public boolean login(String email, String password) {
		System.out.println(" * RemoteFaçade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	public List<VueloDTO> getVuelos() {
		System.out.println(" * RemoteFaçade getVuelos");
		return BusquedaService.getInstance().getVuelos();
	}

	public boolean reserva(Cliente cliente, String idReserva, Vuelo vuelo, int nPersonas) {
		if (state != null) {
			System.out.println(" * RemoteFaçade reserva  : " + idReserva);
			return ReservaService.getInstance().reserva(cliente, idReserva, vuelo, nPersonas);
		} else {
			return false;
		}
	}
	
	public List<ReservaDTO> getReservas(String email){
		System.out.println(" * RemoteFaçade getReservas");
		return BusquedaService.getInstance().getReservas(email);
	}
}