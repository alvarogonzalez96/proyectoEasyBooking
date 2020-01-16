//AEROLINEA
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea
{
    @PrimaryKey
    long id;
    String nombre = null;

    

    public Aerolinea(String nombre)
    {
        this.nombre = nombre;
        
    }
}