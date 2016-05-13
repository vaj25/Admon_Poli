package gr23.fia.ues.sv.admon_poli;




import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class ReservaEliminarActivity extends Activity {
    EditText IdReserva;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_eliminar);
        controlhelper=new ControlBD (this);
        IdReserva=(EditText)findViewById(R.id.IdReserva);
    }
    public void eliminarReserva(View v){
        String regEliminadas;
        Reserva reserva=new Reserva();
        String idreserva=IdReserva.getText().toString();
        reserva.setIdReserva(Integer.parseInt(idreserva));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(reserva);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}