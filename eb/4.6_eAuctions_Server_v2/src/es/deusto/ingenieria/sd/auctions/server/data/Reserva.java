//RESERVA
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva
{
    @PrimaryKey
    long id_Reserva;
    Vuelo vuelo = null;
    int nPersonas = 0;

    

    public Reserva(Vuelo vuelo, int nPersonas)
    {
        this.vuelo = vuelo;
        this.nPersonas = nPersonas;
    }
}