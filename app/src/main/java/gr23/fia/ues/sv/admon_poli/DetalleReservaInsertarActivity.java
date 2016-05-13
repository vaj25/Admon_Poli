package gr23.fia.ues.sv.admon_poli;







import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleReservaInsertarActivity extends Activity {

    ControlBD helper;
    EditText IdReserva;
    EditText IdArea;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_insertar);
        helper = new ControlBD(this);
        IdReserva = (EditText) findViewById(R.id.IdReserva);
        IdArea = (EditText) findViewById(R.id.IdArea);
    }

    public void insertarDetalleReserva(View v) {                  //metodo convocado en el evento onclick del boton insertar en el layout
        String idreserva=IdReserva.getText().toString();
        String idarea=IdArea.getText().toString();
        String regInsertados;
        DetalleReserva  detalleReserva =new DetalleReserva();
        detalleReserva.setIdReserva(Integer.parseInt(idreserva));
        detalleReserva.setIdArea(Integer.parseInt(idarea));
        helper.abrir();
        regInsertados=helper.insertar(detalleReserva);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        IdReserva.setText("");
        IdArea.setText("");
    }
}