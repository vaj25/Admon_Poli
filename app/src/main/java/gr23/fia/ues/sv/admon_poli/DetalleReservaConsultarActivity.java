package gr23.fia.ues.sv.admon_poli;







import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleReservaConsultarActivity extends Activity {

    ControlBD helper;
    EditText IdReserva;
    EditText IdArea;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_consultar);
        helper = new ControlBD(this);
        IdReserva = (EditText) findViewById(R.id.IdReserva);
        IdArea = (EditText) findViewById(R.id.IdArea);
    }


    public void consultarDetalleReserva(View v) {
        helper.abrir();
        String idreserva=IdReserva.getText().toString();
        DetalleReserva detalleReserva = helper.consultarDetalleReserva(Integer.parseInt(idreserva));
        helper.cerrar();
        if(detalleReserva == null)
            Toast.makeText(this, "Reserva con Id " + IdReserva.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();

        else{
           // String aux = String.valueOf(detalleReserva.getIdArea());
            IdArea.setText(String.valueOf(detalleReserva.getIdArea()));
        }
    }
    public void limpiarTexto(View v){
        IdReserva.setText("");
        IdArea.setText("");
    }
}
