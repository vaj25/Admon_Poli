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

public class ActividadConsultarActivity extends Activity {
    ControlBD helper;
    EditText editNombreActividad;
    //EditText editIdConsultar;
    Spinner sActividad;
    List<Actividad> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_consultar);
        helper = new ControlBD(this);
        sActividad = (Spinner) findViewById(R.id.selectActividad);
        lista = new ArrayList<>();
        //editIdConsultar=(EditText) findViewById(R.id.editIdConsultar);
        editNombreActividad= (EditText) findViewById(R.id.editNombreActividad);
        lista=helper.consultaActividad();
        ArrayAdapter<Actividad> adaptador =new ArrayAdapter<Actividad>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sActividad.setAdapter(adaptador);
    }

    public void consultar(View v){
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
        helper.abrir();

        Actividad actividad = helper.consultarActividad(idactividad);
        helper.cerrar();
        if(actividad == null)
            Toast.makeText(this, "Actividad con Identificador " + String.valueOf(idactividad) +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombreActividad.setText("Nombre: "+ "\n"+actividad.getNombre());
        }
    }

    public void limpiarTexto(View v){
        //editIdConsultar.setText("");
        editNombreActividad.setText("");
    }
}
