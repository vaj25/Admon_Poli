package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.provider.CalendarContract;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SolicitudInsertarActivity extends Activity {

    ControlBD helper;
    EditText fechaReserva;
    EditText cantAsistentes;
    EditText horasReserva;
    EditText dui;
    Spinner actividad;
    Spinner sAdmin;
    List<String> lista;
    int idSolicitud;
    Calendar fechaActual = GregorianCalendar.getInstance() ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_insertar);
        helper = new ControlBD(this);

        actividad = (Spinner) findViewById(R.id.selectActividad) ;
        sAdmin = (Spinner) findViewById(R.id.selectAdmin);
        cantAsistentes = (EditText) findViewById(R.id.txtCantAsistentes) ;
        fechaReserva = (EditText) findViewById(R.id.txtFechaReserva) ;
        horasReserva = (EditText) findViewById(R.id.txtHorasReservadas) ;
        dui = (EditText) findViewById(R.id.txtDui) ;

        LinkedList acts = new LinkedList();
        helper.abrir();
        idSolicitud = helper.contarRegistros("solicitud","idsolicitud");
        int count = helper.count("actividad");
        for(int i = 1; i<=count; i++){
            Actividad act = helper.consultarActividad(i) ;
            acts.add(new Actividad(act.getIdActividad(), act.getNombre()));
        }

        lista = new ArrayList<>();
        lista=helper.consultaAdministrador();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAdmin.setAdapter(adaptador);

        ArrayAdapter spinner_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, acts);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actividad.setAdapter(spinner_adapter);
    }

    public void insertarSolicitud(View v) {
        int position= sAdmin.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idadmin=0;
        while( iterador.hasNext() ) {
            Administrador admin = (Administrador) iterador.next();
            if(count==position){
                idadmin=admin.getIdAdministrador();
            }
            count++;
        }

        int cantAs = Integer.parseInt(cantAsistentes.getText().toString()) ;
        String fecha = fechaReserva.getText().toString() ;
        int idact = actividad.getSelectedItemPosition() + 1 ; //cambiar
        String horas = horasReserva.getText().toString();
        String duiString = dui.getText().toString() ;

        String regInsertados;
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(idSolicitud);
        solicitud.setEstado("Pendiente"); //siempre se tiene ese estado al principio
        solicitud.setFechaSolicitud(sdf.format(fechaActual.getTime()));
        solicitud.setFechaReserva(fecha);
        solicitud.setCantAsistentes(cantAs);

        solicitud.setIdAdministrador(idadmin);
        solicitud.setIdActividad(idact);
        solicitud.setDui(duiString);
        solicitud.setMontoArea(20.30);
        solicitud.setHoraReservada(horas+".00");

        helper.abrir();
        regInsertados = helper.insertar(solicitud);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        fechaReserva.setText("");
        cantAsistentes.setText("");
        horasReserva.setText("");
        dui.setText("");
    }
}
