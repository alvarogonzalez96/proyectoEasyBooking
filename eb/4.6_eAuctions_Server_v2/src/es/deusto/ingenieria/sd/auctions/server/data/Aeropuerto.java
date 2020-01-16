
//AEROPUERTO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto
{
    @PrimaryKey
    String id_aeropuerto;
    String nombre = null;
    String provincia = null;

    

    public Aeropuerto(String nombre, String provincia)
    {
        this.nombre = nombre;
        this.provincia = provincia;
        
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.price = price;
    }
    
    public String getProvincia() {
    	return provincia;
    }
    
    public void setProvincia(String provincia) {
    	this.provincia = provincia;
    }
}
