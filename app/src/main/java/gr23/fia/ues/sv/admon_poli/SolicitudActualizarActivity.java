package gr23.fia.ues.sv.admon_poli;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SolicitudActualizarActivity extends Activity {

    ControlBD helper;
    EditText idSolicitud;
    EditText cantAsistentes;
    EditText actividad;
    EditText fechaReserva;
    EditText fechaSolicitud;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_actualizar);
        helper = new ControlBD(this);

        idSolicitud = (EditText) findViewById(R.id.txtIdSolicitud);
        cantAsistentes = (EditText) findViewById(R.id.txtCantAsistentes);
        fechaReserva= (EditText) findViewById(R.id.txtFechaReserva);
        fechaSolicitud = (EditText) findViewById(R.id.txtFechaSolicitud);
        actividad = (EditText) findViewById(R.id.txtActividad);

    }

    public void actualizarSolicitud(View v) {
        Solicitud solicitud = new Solicitud() ;
        solicitud.setIdSolicitud(Integer.parseInt(idSolicitud.getText().toString()));
        solicitud.setCantAsistentes(Integer.parseInt(cantAsistentes.getText().toString()));
        solicitud.setFechaReserva(fechaReserva.getText().toString());
        solicitud.setFechaSolicitud(fechaSolicitud.getText().toString());
        solicitud.setIdActividad(Integer.parseInt(idSolicitud.getText().toString()));

        //solo para que funcione
        solicitud.setDui("128978562");
        solicitud.setIdAdministrador(1);
        solicitud.setMontoArea(45.00);

        helper.abrir();
        String estado = helper.actualizar(solicitud);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idSolicitud.setText("") ;
        cantAsistentes.setText("") ;
        fechaReserva.setText("") ;
        fechaSolicitud.setText("") ;
        actividad.setText("") ;

    }
}
