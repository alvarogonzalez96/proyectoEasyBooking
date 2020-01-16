package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;

public class VueloDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String idVuelo;
	private double precio;
	private double precio_business;
	private String hora_salida;
	private String hora_llegada;
	
	public String getidVuelo() {
		return idVuelo;
	}
	
	public void setidVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public double getPrecioBusiness(){
		return precio_business;
	}

	public void setPrecioBusiness(double precio_business){
		this.precio_business = precio_business;
	}

	public String getHoraLlegada(){
		return hora_llegada;
	}

	public void setHoraLlegada(String hora_llegada){
		this.hora_llegada = hora_llegada;
	}

	public String getHoraSalida(){
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida){
		this.horaSalida = horaSalida;
	}
}