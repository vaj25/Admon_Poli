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

public class ActividadActualizarActivity extends Activity {
    ControlBD helper;
    //EditText editIdActividad;
    Spinner sActividad;
    List<Actividad> lista;
    EditText editNombreActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_actualizar);
        editNombreActividad = (EditText) findViewById(R.id.editNombreActividad);
        helper = new ControlBD(this);
        sActividad = (Spinner) findViewById(R.id.selecActualizarActividad);
        lista = new ArrayList<>();
        lista=helper.consultaActividad();
        ArrayAdapter<Actividad> adaptador =new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sActividad.setAdapter(adaptador);
        //editIdActividad = (EditText) findViewById(R.id.editIdActividad);

    }

    public void actualizarActividad(View v){
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
        Actividad actividad= new Actividad();
        actividad.setIdActividad(idactividad);
        actividad.setNombre(editNombreActividad.getText().toString());
        helper.abrir();
        String stado=helper.actualizar(actividad);
        helper.cerrar();
        Toast.makeText(this, stado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        //editIdActividad.setText("");
        editNombreActividad.setText("");
    }
}
