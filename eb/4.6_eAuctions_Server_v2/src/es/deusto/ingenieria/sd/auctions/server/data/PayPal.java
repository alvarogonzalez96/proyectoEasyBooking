//PAYPAL
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PayPal extends FormaDePago
{
    String descripcion = null;

    

    public PayPal(String descripcion)
    {
        this.descripcion = descripcion;
        
    }
}