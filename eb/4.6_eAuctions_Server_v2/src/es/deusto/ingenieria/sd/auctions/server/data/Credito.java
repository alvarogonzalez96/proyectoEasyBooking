//CREDITO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Credito extends FormaDePago
{
    String descripcion = null;

    

    public Credito(String descripcion)
    {
        this.descripcion = descripcion;
        
    }
}