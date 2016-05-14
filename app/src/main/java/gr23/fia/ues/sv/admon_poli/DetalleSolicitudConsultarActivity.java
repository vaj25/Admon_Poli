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

public class DetalleSolicitudConsultarActivity extends Activity {
    ControlBD helper;
    EditText idDescripcion;
    Spinner sSolicitud;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_consultar);
        helper = new ControlBD(this);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        sSolicitud = (Spinner) findViewById(R.id.selectSolicitud);
        sArea = (Spinner) findViewById(R.id.selectArea);

        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaSolicitud();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSolicitud.setAdapter(adaptador1);
    }
    public void consultarDetalleSolicitud(View v) {
        helper.abrir();
        int position= sSolicitud.getSelectedItemPosition();
        int position1= sArea.getSelectedItemPosition();
        //int count = helper.count("area");
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
            Solicitud soli = (Solicitud) iterador1.next();
            if(count1==position1){
                idsolicitud=soli.getIdSolicitud();
            }
            count1++;
        }
        DetalleSolicitud ds = helper.consultarDS(idsolicitud,idarea);
        helper.cerrar();
        if(ds == null)
            Toast.makeText(this, "Deporte-Area no registrado", Toast.LENGTH_LONG).show();
        else{
            idDescripcion.setText(String.valueOf(ds.getDescripcion()));
        }
    }
    public void limpiarTexto(View v) {
        idDescripcion.setText("");
    }
}