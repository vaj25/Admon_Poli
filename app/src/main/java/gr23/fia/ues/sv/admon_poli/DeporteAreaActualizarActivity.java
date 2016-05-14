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

public class DeporteAreaActualizarActivity extends Activity {
    ControlBD helper;
    Spinner sDeporte;
    Spinner sArea;
    List<Area> lista;
    List<Deporte> lista1;
    EditText idDescripcion;
    EditText idActivo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_actualizar);
        helper = new ControlBD(this);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);
        sArea = (Spinner) findViewById(R.id.selectArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);
        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<Area> adaptador =new ArrayAdapter<Area>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<Deporte> adaptador1 =new ArrayAdapter<Deporte>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);
    }
    public void actualizarDeporteArea(View v) {
        String regInsertados;
        String iddescripcion=idDescripcion.getText().toString();
        String idactivo=idActivo.getText().toString();
        DeporteArea da= new DeporteArea();
        int position= sArea.getSelectedItemPosition();
        int position1= sDeporte.getSelectedItemPosition();
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
            Deporte dep = (Deporte) iterador1.next();
            if(count1==position1){
                iddeporte=dep.getIdDeporte();
            }
            count1++;
        }
        da.setIdDeporte(iddeporte);
        da.setIdArea(idarea);
        da.setDescripcion(iddescripcion);
        da.setActivo(idactivo);
        helper.abrir();
        String estado = helper.actualizar(da);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        idDescripcion.setText("");
        idActivo.setText("");
    }
}
