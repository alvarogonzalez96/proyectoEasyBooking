//RESERVA
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva
{
    @PrimaryKey
    String idReserva;
    Vuelo vuelo = null;
    int nPersonas = 0;

    

    public Reserva(String idReserva, Vuelo vuelo, int nPersonas)
    {
    	this.idReserva = idReserva;
        this.vuelo = vuelo;
        this.nPersonas = nPersonas;
    }
    
    public String getIdReserva() {
    	return idReserva;
    }
    
    public void setIdReserva(String idReserva) {
    	this.idReserva = idReserva;
    }
    
    public Vuelo getVuelo() {
    	return vuelo;
    }
    
    public void setVuelo(Vuelo vuelo) {
    	this.vuelo = vuelo;
    }
    
    
    public int getNPersonas() {
    	return nPersonas;
    }
    
    public void setNPersonas(int nPersonas) {
    	this.nPersonas = nPersonas;
    }
}