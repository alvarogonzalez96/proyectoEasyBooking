//RESERVA
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva
{
    @PrimaryKey
    long id_Reserva;
    String descripcion = null;

    

    public Reserva(String descripcion)
    {
        this.descripcion = descripcion;
        
    }
}