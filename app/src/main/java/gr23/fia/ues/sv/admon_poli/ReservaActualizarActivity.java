package gr23.fia.ues.sv.admon_poli;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ReservaActualizarActivity extends Activity {

    ControlBD helper;
    EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
    EditText IdHorario;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_actualizar);
        helper = new ControlBD(this);
        IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
    }

    public void actualizarReserva(View v) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(Integer.parseInt(IdReserva.getText().toString()));
        reserva.setFechaReserva(FechaReserva.getText().toString());
        reserva.setTiempoReserva(TiempoReserva.getText().toString());
        reserva.setIdHorario(Integer.parseInt(IdHorario.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(reserva);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        FechaReserva.setText("");
        TiempoReserva.setText("");
        IdReserva.setText("");
        IdHorario.setText("");
    }
}