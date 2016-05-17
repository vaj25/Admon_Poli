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

public class ActividadEliminarActivity extends Activity {
    //EditText editId;
    Spinner sActividad;
    List<Actividad> lista;
    ControlBD controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_eliminar);
        controlhelper= new ControlBD(this);
        sActividad = (Spinner) findViewById(R.id.selecEliminarActividad);
        lista = new ArrayList<>();
        //editId=(EditText)findViewById(R.id.editIdEliminar);
        lista=controlhelper.consultaActividad();
        ArrayAdapter<Actividad> adaptador =new ArrayAdapter<Actividad>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sActividad.setAdapter(adaptador);
    }

    public void eliminarActividad(View v){
        int position= sActividad.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idactividad=0;
        while( iterador.hasNext() ) {
            Actividad actividad = (Actividad) iterador.next();
            if(count==position){
                idactividad=actividad.getIdActividad();
            }
            count++;
        }
        int regEliminadas;
        Actividad actividad= new Actividad();
        actividad.setIdActividad(idactividad);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(actividad);
        controlhelper.cerrar();
        Toast.makeText(this,"filas afectadas="+ regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
