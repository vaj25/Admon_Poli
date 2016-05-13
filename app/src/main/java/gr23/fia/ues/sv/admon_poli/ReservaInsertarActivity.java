package gr23.fia.ues.sv.admon_poli;





import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ReservaInsertarActivity extends Activity {

    ControlBD helper;
    EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
    EditText IdHorario;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_insertar);
        helper = new ControlBD(this);
        IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
    }

    public void insertarReserva(View v) {                  //metodo convocado en el evento onclick del boton insertar en el layout
        String idreversa=IdReserva.getText().toString();
        String fechareserva=FechaReserva.getText().toString();
        String tiemporeserva=TiempoReserva.getText().toString();
        String idhorario=IdHorario.getText().toString();
        String regInsertados;
        Reserva reserva =new Reserva();
        reserva.setIdReserva(Integer.parseInt(idreversa));
        reserva.setFechaReserva(fechareserva);
        reserva.setTiempoReserva(tiemporeserva);
        reserva.setIdHorario(Integer.parseInt(idhorario));
        helper.abrir();
        regInsertados=helper.insertar(reserva);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        IdReserva.setText("");
        FechaReserva.setText("");
        TiempoReserva.setText("");
        IdHorario.setText("");
    }
}