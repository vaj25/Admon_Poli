package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolicitudConsultarActivity extends Activity {
    ControlBD helper;
    Spinner idSolicitud;
    List<Solicitud> lista ;
    EditText cantAsistentes;
    EditText actividad;
    EditText fechaReserva;
    EditText fechaSolicitud;
    EditText estado;
    EditText monto;
    EditText dui;
    EditText horaReserva;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_consultar);
        helper = new ControlBD(this);

        idSolicitud = (Spinner) findViewById(R.id.selectSolicitud) ;
        cantAsistentes = (EditText) findViewById(R.id.editCanAsistentes);
        fechaReserva= (EditText) findViewById(R.id.ediFechaReserva);
        fechaSolicitud = (EditText) findViewById(R.id.ediFechaSolicitud);
        actividad = (EditText) findViewById(R.id.ediActividad);
        estado = (EditText) findViewById(R.id.ediEstado);
        monto = (EditText) findViewById(R.id.ediMonto);
        dui = (EditText) findViewById(R.id.editDui);
        horaReserva = (EditText) findViewById(R.id.editHorasReservadas);

        lista =new ArrayList<>();
        lista=helper.consultaSolicitud();
        ArrayAdapter<Solicitud> adaptador =new ArrayAdapter<Solicitud>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSolicitud.setAdapter(adaptador);

    }

    public void consultarSolicitud(View v) {
        helper.abrir();
        int position = idSolicitud.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idsolicitud=0;
        while(iterador.hasNext() ) {
            Solicitud soli = (Solicitud) iterador.next();
            if(count==position){
                idsolicitud=soli.getIdSolicitud();
            }
            count++;
        }
        Solicitud solicitud = helper.consultarSolicitud(idsolicitud);
        helper.cerrar();
        if(solicitud == null)
            Toast.makeText(this, "Solicitud con Id " + idsolicitud +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            cantAsistentes.setText(String.valueOf(solicitud.getCantAsistentes())) ;
            fechaReserva.setText(solicitud.getFechaReserva()) ;
            fechaSolicitud.setText(solicitud.getFechaSolicitud()) ;
            actividad.setText(String.valueOf(solicitud.getIdActividad())) ;
            estado.setText(solicitud.getEstado()) ;
            monto.setText(String.valueOf(solicitud.getMontoArea())) ;
            dui.setText(String.valueOf(solicitud.getDui())) ;
            horaReserva.setText(String.valueOf(solicitud.getHoraReservada())) ;
        }
    }
    public void limpiarTexto(View v){

        cantAsistentes.setText("") ;
        fechaReserva.setText("") ;
        fechaSolicitud.setText("") ;
        actividad.setText("") ;
        estado.setText("") ;
        monto.setText("") ;
        dui.setText("") ;
        horaReserva.setText("") ;
    }
}

