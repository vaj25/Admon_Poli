package gr23.fia.ues.sv.admon_poli;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SolicitudActualizarActivity extends Activity {

    ControlBD helper;
    Spinner idSolicitud;
    EditText cantAsistentes;
    Spinner actividad;
    EditText fechaReserva;
    Spinner estado ;
    List<Solicitud> lista ;
    String id;
    String idCompare = "01" ;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_actualizar);
        helper = new ControlBD(this);

        idSolicitud = (Spinner) findViewById(R.id.selectSolicitud);
        cantAsistentes = (EditText) findViewById(R.id.txtCantAsistentes);
        fechaReserva= (EditText) findViewById(R.id.txtFechaReserva);
        actividad = (Spinner) findViewById(R.id.selectActividad);
        estado = (Spinner) findViewById(R.id.selectEstado);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("idUsuario");

        if(id.compareTo(idCompare) != 0){
            estado.setEnabled(false);
        }else{
            cantAsistentes.setEnabled(false);
            fechaReserva.setEnabled(false);
            actividad.setEnabled(false);
        }

        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,R.array.estados,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(adapter);

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

        lista =new ArrayList<>();
        lista=helper.consultaSolicitud();
        ArrayAdapter<Solicitud> adaptador =new ArrayAdapter<Solicitud>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSolicitud.setAdapter(adaptador);

    }

    public void actualizarSolicitud(View v) {

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

        if(id.compareTo(idCompare) != 0){
            solicitud.setCantAsistentes(Integer.parseInt(cantAsistentes.getText().toString()));
            solicitud.setFechaReserva(fechaReserva.getText().toString());
            solicitud.setIdActividad(actividad.getSelectedItemPosition() + 1);
        }else{
            String [] estados = getResources().getStringArray(R.array.estados);
            String es = "";
            for (int i=0; i<3; i++) {
                if(estado.getSelectedItemPosition() == i){
                    es = estados[i] ;
                }
            }
            solicitud.setEstado(es);
        }

        String estado = helper.actualizar(solicitud);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        cantAsistentes.setText("") ;
        fechaReserva.setText("") ;
    }
}
