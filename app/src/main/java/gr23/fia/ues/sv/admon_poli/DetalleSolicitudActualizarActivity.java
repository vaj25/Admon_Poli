package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetalleSolicitudActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText idDescripcion;
    Spinner sSolicitud;
    Spinner sArea;
    List<Area> lista;
    List<Solicitud> lista1;

    public void onCreate(Bundle savedInstanceState) {
        helper = new ControlBD(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_actualizar);
        sSolicitud = (Spinner) findViewById(R.id.selectSolicitud);
        sArea = (Spinner) findViewById(R.id.selectArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);

        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<Area> adaptador =new ArrayAdapter<Area>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaSolicitud();
        ArrayAdapter<Solicitud> adaptador1 =new ArrayAdapter<Solicitud>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSolicitud.setAdapter(adaptador1);
    }
    public void actualizarDetalleSolicitud(View v) {
        String iddescripcion=idDescripcion.getText().toString();
        DetalleSolicitud ds= new DetalleSolicitud();
        int position= sArea.getSelectedItemPosition();
        int position1= sSolicitud.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        Iterator iterador1 = lista1.listIterator();

        int count=0;
        int idarea=0;
        int idsolicitud=0;
        while( iterador.hasNext() ) {
            Area area = (Area) iterador.next();
            if(count==position){
                idarea=area.getIdArea();
            }
            count++;
        }
        int count1=0;
        while( iterador1.hasNext() ) {
            Solicitud sol = (Solicitud) iterador1.next();
            if(count1==position1){
                idsolicitud=sol.getIdSolicitud();
            }
            count1++;
        }
        ds.setIdSolicitud(idsolicitud);
        ds.setIdArea(idarea);
        ds.setDescripcion(iddescripcion);
        helper.abrir();
        String estado = helper.actualizar(ds);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        idDescripcion.setText("");
    }

}
