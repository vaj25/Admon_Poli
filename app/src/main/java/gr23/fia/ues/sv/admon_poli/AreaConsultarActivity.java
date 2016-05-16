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

public class AreaConsultarActivity extends Activity {
    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;
    Spinner sArea;
    List<Area> lista;
    ControlBD helper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_area_consultar);
        helper = new ControlBD(this);
        sArea = (Spinner) findViewById(R.id.selectArea);
        nombreArea = (EditText) findViewById(R.id.nombreArea);
        capacidadArea = (EditText) findViewById(R.id.capacidadArea);
        aream2 = (EditText) findViewById(R.id.aream2);
        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<Area> adaptador =new ArrayAdapter<Area>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);
    }
    public void consultarArea(View v) {
        int position= sArea.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idarea=0;
        while( iterador.hasNext() ) {
            Area area = (Area) iterador.next();
            if(count==position){
                idarea=area.getIdArea();
            }
            count++;
        }
        helper.abrir();

        Area area = helper.consultarArea(idarea);
        helper.cerrar();
        if(area == null)
            Toast.makeText(this, "Area con Identificador " + String.valueOf(idarea) +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            nombreArea.setText("Nombre: "+ "\n"+area.getNombre());
            capacidadArea.setText("Capacidad: "+ "\n"+String.valueOf(area.getCapacidad()));
            aream2.setText("Area en m2: "+ "\n"+String.valueOf(area.getArea()));
        }
    }
    public void limpiarTexto(View v){
        nombreArea.setText("");
        capacidadArea.setText("");
        aream2.setText("");
    }
}



