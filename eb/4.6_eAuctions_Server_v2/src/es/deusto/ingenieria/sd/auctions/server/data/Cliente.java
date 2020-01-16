//CLIENTE
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cliente extends Aeropuerto
{
    @PrimaryKey
    long id;
    String name = null;
    int age = 0;
    int telefono = 0;
    String tarjeta_credito = null;
    Long id_aeropuerto;
    
    public Cliente(String name, int age, int telefono, String tarjeta_credito)
    {
        this.name = name;
        this.age = age;
        this.telefono = telefono;
        this.tarjeta_credito = tarjeta_credito;
        
    }
}