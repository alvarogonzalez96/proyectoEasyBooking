//CLIENTE
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;

@PersistenceCapable
public class Cliente extends Aeropuerto
{
    @PrimaryKey
    String id;
    String email = null;
    int age = 0;
    int telefono = 0;
    String tarjetaCredito = null;
    ArrayList<String> reservas;
    
    public Cliente(String email, int age, int telefono, String tarjeta_credito, ArrayList<int> reservas)
    {
        this.email = email;
        this.age = age;
        this.telefono = telefono;
        this.tarjeta_credito = tarjeta_credito;
        this.reservas = reservas;
        
    }
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    

    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    

    public int getAge() {
    	return age;
    }
    
    public void setAge(int Age) {
    	this.age = age;
    } 

    public int getTelefono() {
    	return telefono;
    }
    
    public void setTelefono(int telefono) {
    	this.telefono = telefono;
    }
    
    public String getTarjetaCredito() {
    	return tarjetaCredito;
    }
    
    public void setTarjetaCredito(String tarjetaCredito) {
    	this.tarjetaCredito = tarjetaCredito;
    }
    
    public ArrayList<String> getReservas() {
    	return reservas;
    }
    
    public void setReservas(ArrayList<String> reservas) {
    	this.reservas = reservas;
    }
    
    public void addReserva(String idReserva) {
    	reservas.add(idReserva);
    }
}