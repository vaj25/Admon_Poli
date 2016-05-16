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

public class AreaEliminarActivity extends Activity {
    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;
    Spinner sArea;
    List<Area> lista;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_eliminar);
        controlhelper=new ControlBD (this);

        sArea = (Spinner) findViewById(R.id.selectArea);
        lista = new ArrayList<>();
        lista=controlhelper.consultaArea();
        ArrayAdapter<Area> adaptador =new ArrayAdapter<Area>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);
    }
    public void eliminarArea(View v){
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

        String regEliminadas;
        Area area=new Area();
        area.setIdArea(idarea);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(area);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
