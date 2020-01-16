
//AEROPUERTO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto
{
    @PrimaryKey
    long id_aeropuerto;
    String nombre = null;
    String provincia = null;
    String attribute = null; //Attribute es String?

    

    public Aeropuerto(String nombre, String provincia, String attribute)
    {
        this.nombre = nombre;
        this.provincia = provincia;
        this.attribute = attribute;
        
    }
}
