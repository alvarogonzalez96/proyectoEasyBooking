//VUELO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo 
{
    @PrimaryKey
    long id_vuelo;
    String origen = null;
    String destino = null;
    Date horaSalida = null;
    Date horaEntrada = null;
    double price = 0.0;
    double precioBusiness = 0.0;
    

    public Vuelo(String origen, String destino, Date horaSalida, Date horaEntrada, double precio, double precioBusiness)
    {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
        this.price = price;
        this.precioBusiness = precioBusiness;
        
    }
}
