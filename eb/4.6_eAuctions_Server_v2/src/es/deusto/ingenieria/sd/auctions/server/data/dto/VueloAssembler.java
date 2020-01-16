package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public class VueloAssembler {
	private static VueloAssembler instance;

	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}

	public VueloDTO entityToDTO(Vuelo vuelo) {
		VueloDTO dto = new VueloDTO();
		
		dto.setIdVuelo(vuelo.getIdVuelo());
		dto.setPrecio(vuelo.getPrecio());
		dto.setPrecioBusiness(vuelo.getPrecioBusiness());
		dto.setHoraSalida(vuelo.getHoraSalida());
		dto.setHoraLlegada(vuelo.getHoraLlegada());
		dto.setAeropuerto(vuelo.getAeropuerto);
		dto.setAerolinea(vuelo.setAerolinea);
		
		return dto;
	}
}