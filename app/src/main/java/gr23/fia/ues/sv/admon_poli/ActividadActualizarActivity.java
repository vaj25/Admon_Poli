package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadActualizarActivity extends Activity {
    ControlBD helper;
    EditText editIdActividad;
    EditText editNombreActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_actualizar);
        helper = new ControlBD(this);
        editIdActividad = (EditText) findViewById(R.id.editIdActividad);
        editNombreActividad = (EditText) findViewById(R.id.editNombreActividad);
    }

    public void actualizarActividad(View v){
        Actividad actividad= new Actividad();
        actividad.setIdActividad( Integer.parseInt(editIdActividad.getText().toString()));
        actividad.setNombre(editNombreActividad.getText().toString());
        helper.abrir();
        String stado=helper.actualizar(actividad);
        helper.cerrar();
        Toast.makeText(this, stado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdActividad.setText("");
        editNombreActividad.setText("");
    }
}
