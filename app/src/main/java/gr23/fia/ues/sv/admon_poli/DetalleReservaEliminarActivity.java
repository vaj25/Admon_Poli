package gr23.fia.ues.sv.admon_poli;




import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DetalleReservaEliminarActivity extends Activity {
    EditText IdReserva;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_eliminar);
        controlhelper=new ControlBD (this);
        IdReserva=(EditText)findViewById(R.id.IdReserva);
    }
    public void eliminarDetalleReserva(View v){
        String regEliminadas;
        DetalleReserva detalleReserva =new DetalleReserva();
        String idreserva=IdReserva.getText().toString();
        detalleReserva.setIdReserva(Integer.parseInt(idreserva));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(detalleReserva);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}