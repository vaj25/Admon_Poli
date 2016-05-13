package gr23.fia.ues.sv.admon_poli;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ReservaConsultarActivity extends Activity {

    ControlBD helper;
    EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
    EditText IdHorario;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_consultar);
        helper = new ControlBD(this);
        IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
    }
    public void consultarReserva(View v) {
        helper.abrir();
        String idreserva=IdReserva.getText().toString();
        Reserva reserva = helper.consultarReserva(Integer.parseInt(idreserva));
        helper.cerrar();
        if(reserva == null)
            Toast.makeText(this, "Reserva con Id " + IdReserva.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();

        else{
            FechaReserva.setText(reserva.getFechaReserva());
            TiempoReserva.setText(reserva.getTiempoReserva());
            String aux = String.valueOf(reserva.getIdHorario());
            IdHorario.setText(aux);
        }
    }
    public void limpiarTexto(View v){
        IdReserva.setText("");
        FechaReserva.setText("");
        TiempoReserva.setText("");
        IdHorario.setText("");
    }
}

