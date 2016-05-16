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

public class DeporteAreaConsultarActivity extends Activity {
    ControlBD helper;
    EditText idDescripcion;
    EditText idActivo;
    Spinner sDeporte;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_consultar);
        helper = new ControlBD(this);
        //idDeporte = (EditText) findViewById(R.id.idDeporte);
        //idArea = (EditText) findViewById(R.id.idArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);
        sArea = (Spinner) findViewById(R.id.selectArea);

        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);
    }
    public void consultarDeporteArea(View v) {
        helper.abrir();
        int position= sArea.getSelectedItemPosition();
        int position1= sDeporte.getSelectedItemPosition();
        //int count = helper.count("area");
        Iterator iterador = lista.listIterator();
        Iterator iterador1 = lista1.listIterator();
        int count=0;
        int idarea=0;
        int iddeporte=0;
        while( iterador.hasNext() ) {
            Area area = (Area) iterador.next();
            if(count==position){
                idarea=area.getIdArea();
            }
            count++;
        }
        int count1=0;
        while( iterador1.hasNext() ) {
            Deporte deporte = (Deporte) iterador1.next();
            if(count1==position1){
                iddeporte=deporte.getIdDeporte();
            }
            count1++;
        }
        DeporteArea da = helper.consultarDeporteArea(iddeporte,idarea);
        helper.cerrar();
        if(da == null)
            Toast.makeText(this, "Deporte-Area no registrado", Toast.LENGTH_LONG).show();
        else{
            idDescripcion.setText("Descripción: "+String.valueOf(da.getDescripcion()));
            idActivo.setText("Status: "+String.valueOf(da.isActivo()));
        }
    }
    public void limpiarTexto(View v) {
        idDescripcion.setText("");
        idActivo.setText("");
    }
}