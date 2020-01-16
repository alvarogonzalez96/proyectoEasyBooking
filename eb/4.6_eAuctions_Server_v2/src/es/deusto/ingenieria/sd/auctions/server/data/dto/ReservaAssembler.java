package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Reserva;

public class ReservaAssembler {
	private static ReservaAssembler instance;

	private ReservaAssembler() { }
	
	public static REservaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaAssembler();
		}

		return instance;
	}

	public ReservaDTO entityToDTO(Reserva reserva) {
		ReservaDTO dto = new ReservaDTO();
		
		dto.setIdReserva(reserva.getIdReserva());
		dto.setNPersonas(reserva.getNPersonas());
		
		return dto;
	}
}