//AEROLINEA
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea
{
    @PrimaryKey
    String id;
    String nombre = null;

    

    public Aerolinea(String nombre)
    {
        this.nombre = nombre;
        
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(double nombre) {
    	this.nombre = nombre;
    }
}