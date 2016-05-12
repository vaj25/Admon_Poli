package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;

public class SolicitudInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText fechaReserva;
    EditText cantAsistentes;
    EditText horasReserva;
    Spinner actividad;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_insertar);
        helper = new ControlBD(this);

        actividad = (Spinner) findViewById(R.id.selectActividad) ;
        cantAsistentes = (EditText) findViewById(R.id.txtCantAsistentes) ;
        fechaReserva = (EditText) findViewById(R.id.txtFechaReserva) ;
        horasReserva = (EditText) findViewById(R.id.txtHorasReservadas) ;

        LinkedList acts = new LinkedList();
        helper.abrir();
        int count = helper.count("actividad");
        for(int i = 1; i<=count; i++){
            Actividad act = helper.consultarActividad(i) ;
            acts.add(new Actividad(act.getIdActividad(), act.getNombre()));
        }
        ArrayAdapter spinner_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, acts);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actividad.setAdapter(spinner_adapter);
    }

    public void insertarSolicitud(View v) {
        int cantAs = Integer.parseInt(cantAsistentes.getText().toString()) ;
        String fecha = fechaReserva.getText().toString() ;
        int idact = 1 ;
        String horas = horasReserva.getText().toString();
        String regInsertados;
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(5);
        solicitud.setEstado("En Proceso"); //siempre se tiene ese estado al principio
        solicitud.setFechaSolicitud("11/05/2016");
        solicitud.setFechaReserva(fecha);
        solicitud.setCantAsistentes(cantAs);
        solicitud.setIdAdministrador(1);
        solicitud.setIdActividad(idact);
        solicitud.setDui("12897856234");
        solicitud.setMontoArea(20.30);
        solicitud.setHoraReservada(horas+".00");

        helper.abrir();
        regInsertados = helper.insertar(solicitud);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {

    }
}
