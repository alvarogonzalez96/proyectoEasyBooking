package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ReservaAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.auctions.server.db.DBManager;

public class BusquedaService {
	
	private static BusquedaService instance;

	private BusquedaService() { }
	
	public static BusquedaService getInstance() {
		if (instance == null) {
			instance = new BusquedaService();
		}

		return instance;
	}

	public List<VueloDTO> getVuelos() {
		return VueloAssembler.getInstance().entityToDTO(DBManager.getInstance().getVuelos());
	}
	
	public List<ReservaDTO> getReservas(String email) {
		return ReservaAssembler.getInstance().entityToDTO(DBManager.getInstance().getReservas(email));
	}
}