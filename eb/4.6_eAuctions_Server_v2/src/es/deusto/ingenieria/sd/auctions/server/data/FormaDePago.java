//FORMA DE PAGO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class FormaDePago
{
    String nombre = null;

    

    public FormaDePago(String nombre)
    {
        this.nombre = nombre;
        
    }
}