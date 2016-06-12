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
    EditText dui;
    Spinner actividad;
    Spinner sAdmin;
    List<String> lista;
    int idSolicitud;
    Spinner sTarifa;
    List<String> listaTarifa;
    Calendar fechaActual = GregorianCalendar.getInstance() ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_insertar);
        helper = new ControlBD(this);

        sTarifa = (Spinner) findViewById(R.id.selectTarifa);
        listaTarifa = new ArrayList<>();
        listaTarifa=helper.consultaTarifa();
        ArrayAdapter<String> adaptadorTarifa =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listaTarifa);
        adaptadorTarifa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTarifa.setAdapter(adaptadorTarifa);

        actividad = (Spinner) findViewById(R.id.selectActividad) ;
        sAdmin = (Spinner) findViewById(R.id.selectAdmin);
        fechaReserva = (EditText) findViewById(R.id.txtFechaReserva) ;
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
        int positionTarifa= sTarifa.getSelectedItemPosition();
        Iterator iteradorTarifa = listaTarifa.listIterator();
        int countTarifa=0;
        int idtarifa=0;
        while( iteradorTarifa.hasNext() ) {
            Tarifa tar = (Tarifa) iteradorTarifa.next();
            if(countTarifa==positionTarifa){
                idtarifa=tar.getIdTarifa();
            }
            countTarifa++;
        }

        String fecha = fechaReserva.getText().toString() ;
        int idact = actividad.getSelectedItemPosition() + 1 ; //cambiar
        String duiString = dui.getText().toString() ;

        String regInsertados;
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(idSolicitud);
        solicitud.setEstado("En Proceso"); //siempre se tiene ese estado al principio
        solicitud.setFechaSolicitud(sdf.format(fechaActual.getTime()));
        solicitud.setFechaReserva(fecha);
        solicitud.setIdAdministrador(idadmin);
        solicitud.setIdActividad(idact);
        solicitud.setIdTarifa(idtarifa);
        solicitud.setDui(duiString);

        helper.abrir();
        regInsertados = helper.insertar(solicitud);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        fechaReserva.setText("");
        dui.setText("");
    }
}
