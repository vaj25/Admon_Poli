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
import java.util.List;

public class AreaActualizarActivity extends Activity {
    ControlBD helper;

    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;
    Spinner sArea;
    List<Area> lista;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_actualizar);
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
    public void actualizarArea(View v) {

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

        Area area = new Area();
        area.setIdArea(idarea);
        area.setNombre(nombreArea.getText().toString());
        String capacidadarea=capacidadArea.getText().toString();
        area.setCapacidad(Integer.parseInt(capacidadarea));
        String aream=aream2.getText().toString();
        area.setArea(Float.parseFloat(aream));
        helper.abrir();
        String estado = helper.actualizar(area);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        nombreArea.setText("");
        capacidadArea.setText("");
        aream2.setText("");

    }
}
