//VUELO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo 
{
    @PrimaryKey
    String id_vuelo;
    String origen = null;
    String destino = null;
    String horaSalida = null;
    String horaEntrada = null;
    double price = 0.0;
    double precioBusiness = 0.0;
    Aeropuerto aeropuerto = null;
    Aerolinea aerolinea = null;
    

    public Vuelo(String origen, String destino, String horaSalida, String horaEntrada, double precio, double precioBusiness, Aeropuerto aeropuerto, Aerolinea aerolinea)
    {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
        this.price = price;
        this.precioBusiness = precioBusiness;
        this.aeropuerto = aeropuerto;
        this.aerolinea = aerolinea;
    }
    
    public String getIdVuelo() {
    	return idVuelo;
    }
    
    public void setIdVuelo(String idVuelo) {
    	this.idVuelo = idVuelo;
    }
    
    public String getOrigen() {
    	return origen;
    }
    
    public void setOrigen(String origen) {
    	this.origen = origen;
    }
    
    public String getDestino() {
    	return destino;
    }
    
    public void setDestino(String destino) {
    	this.destino = destino;
    }
    
    public String getHoraSalida() {
    	return horaSalida;
    }
    
    public void setHoraSalida(String horaSalida ) {
    	this.horaSalida = horaSalida;
    }
    
    public String getHoraEntrada() {
    	return horaEntrada;
    }
    
    public void setHoraEntrada(String horaEntrada ) {
    	this.horaEntrada = horaEntrada;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public double getPriceBusiness() {
    	return priceBusiness;
    }
    
    public void setPriceBusiness(double priceBusiness) {
    	this.price = priceBusiness;
    }
    
    public Aeropuerto getAeropuerto() {
    	return aeropuerto;
    }
    
    public void setAeropuerto(Aeropuerto aeropuerto) {
    	this.aeropuerto = aeropuerto;
    }
    
    public Aerolinea getAerolinea() {
    	return aerolinea;
    }
    
    public void setAerolinea(Aerolinea aerolinea) {
    	this.aerolinea = aerolinea;
    }
}
