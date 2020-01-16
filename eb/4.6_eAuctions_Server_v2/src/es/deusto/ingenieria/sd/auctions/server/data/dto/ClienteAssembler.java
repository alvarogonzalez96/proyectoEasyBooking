package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.Cliente;

public class ClienteAssembler {
	private static ClienteAssembler instance;

	private ClienteAssembler() { }
	
	public static ClienteAssembler getInstance() {
		if (instance == null) {
			instance = new ClienteAssembler();
		}

		return instance;
	}

	public ClienteDTO entityToDTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		
		dto.setNombre(cliente.getNombre());
		dto.setTelefono(cliente.getTelefono());
		
		return dto;
	}
}