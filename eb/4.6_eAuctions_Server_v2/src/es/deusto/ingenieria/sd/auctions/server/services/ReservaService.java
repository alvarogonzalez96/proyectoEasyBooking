package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.Calendar;

//import es.deusto.ingenieria.sd.auctions.server.data.Article;
import es.deusto.ingenieria.sd.auctions.server.data.Reserva;
import es.deusto.ingenieria.sd.auctions.server.data.Cliente;
import es.deusto.ingenieria.sd.auctions.server.db.DBManager;

public class ReservaService {

	private static ReservaService instance;

	private ReservaService() { }

	public static ReservaService getInstance() {
		if (instance == null) {
			instance = new ReservaService();
		}

		return instance;
	}

	public boolean reserva(Cliente cliente, String idReserva, Vuelo vuelo, int nPersonas) {

		Reserva newReserva = new Reserva();		
		newReserva.setIdReserva(idReserva);
		newReserva.setnPersonas(nPersonas);
		newReserva.setVuelo(vuelo);
		cliente.addReserva(idReserva);

		DBManager.getInstance().storeObjectInDB(newReserva);

		return true;
	} else {
		return false;
	}
}
}