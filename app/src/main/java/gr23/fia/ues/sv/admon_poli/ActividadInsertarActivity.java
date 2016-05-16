package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadInsertarActivity extends Activity {

    ControlBD helper;
   // EditText editIdActividad;
    EditText editNombreActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_insertar);
        helper = new ControlBD(this);
       // editIdActividad = (EditText) findViewById(R.id.editIdActividad);
        editNombreActividad = (EditText) findViewById(R.id.editNombreActividad);
    }

    public void insertarActividad(View v){
      //  int idActividad = Integer.parseInt(editIdActividad.getText().toString());
        String nombreActividad=editNombreActividad.getText().toString();
        String regInsertados;
        Actividad actividad=new Actividad();
        //actividad.setIdActividad(idActividad);
        int idactiv=helper.contarRegistros("actividad","idactividad");
        actividad.setIdActividad(idactiv);
        actividad.setNombre(nombreActividad);
        helper.abrir();
        regInsertados=helper.insertar(actividad);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
       // editIdActividad.setText("");
        editNombreActividad.setText("");
    }
}
