package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SolicitudConsultarActivity extends Activity {
    ControlBD helper;
    EditText idSolicitud;
    EditText cantAsistentes;
    EditText actividad;
    EditText fechaReserva;
    EditText fechaSolicitud;
    EditText estado;
    EditText monto;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_consultar);
        helper = new ControlBD(this);

        idSolicitud = (EditText) findViewById(R.id.txtIdSolicitud);
        cantAsistentes = (EditText) findViewById(R.id.editCanAsistentes);
        fechaReserva= (EditText) findViewById(R.id.ediFechaReserva);
        fechaSolicitud = (EditText) findViewById(R.id.ediFechaSolicitud);
        actividad = (EditText) findViewById(R.id.ediActividad);
        estado = (EditText) findViewById(R.id.ediEstado);
        monto = (EditText) findViewById(R.id.ediMonto);

    }

    public void consultarSolicitud(View v) {
        helper.abrir();
        String idsolicictud = idSolicitud.getText().toString();
        Solicitud solicitud = helper.consultarSolicitud(Integer.parseInt(idsolicictud));
        helper.cerrar();
        if(solicitud == null)
            Toast.makeText(this, "Solicitud con Id " + idSolicitud.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            cantAsistentes.setText(String.valueOf(solicitud.getCantAsistentes())) ;
            fechaReserva.setText(solicitud.getFechaReserva()) ;
            fechaSolicitud.setText(solicitud.getFechaSolicitud()) ;
            actividad.setText(String.valueOf(solicitud.getIdActividad())) ;
            estado.setText(solicitud.getEstado()) ;
            monto.setText(String.valueOf(solicitud.getMontoArea())) ;
        }
    }
    public void limpiarTexto(View v){
        idSolicitud.setText("") ;
        cantAsistentes.setText("") ;
        fechaReserva.setText("") ;
        fechaSolicitud.setText("") ;
        actividad.setText("") ;
        estado.setText("") ;
        monto.setText("") ;
    }
}

