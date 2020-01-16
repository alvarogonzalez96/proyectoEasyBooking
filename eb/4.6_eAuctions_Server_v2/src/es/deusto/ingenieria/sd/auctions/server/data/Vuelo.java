//VUELO
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo 
{
    @PrimaryKey
    String id_vuelo;
    String origen = null;
    String destino = null;
    Date horaSalida = null;
    Date horaEntrada = null;
    double price = 0.0;
    double precioBusiness = 0.0;
    Aeropuerto aeropuerto = null;
    Aerolinea aerolinea = null;
    

    public Vuelo(String origen, String destino, Date horaSalida, Date horaEntrada, double precio, double precioBusiness, Aeropuerto aeropuerto, Aerolinea aerolinea)
    {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
        this.price = price;
        this.precioBusiness = precioBusiness;
        this.aeropuerto = aeropuerto;
        this.aerolinea = aerolinea;
    }
}
