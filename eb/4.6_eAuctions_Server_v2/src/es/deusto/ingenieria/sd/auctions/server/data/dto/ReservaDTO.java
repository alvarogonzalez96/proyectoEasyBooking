package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

public class ReservaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String idReserva;
	private Vuelo vuelo;
	private int nPersonas;
	
	public String getidReserva() {
		return idReserva;
	}
	
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	
	public int getNPersonas() {
		return nPersonas;
	}
	
	public void setNPersonas(int nPersonas) {
		this.nPersonas = nPersonas;
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
}