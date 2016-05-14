package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadConsultarActivity extends Activity {
    ControlBD helper;
    EditText editNombreActividad;
    EditText editIdConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_consultar);
        helper = new ControlBD(this);
        editIdConsultar=(EditText) findViewById(R.id.editIdConsultar);
        editNombreActividad= (EditText) findViewById(R.id.editNombreActividad);
    }

    public void consultar(View v){
        helper.abrir();
        //Toast.makeText(this,"id actividad"+Integer.parseInt(editIdConsultar.getText().toString()),Toast.LENGTH_LONG).show();
        Actividad actividad= helper.consultarActividad(Integer.parseInt(editIdConsultar.getText().toString()));
        helper.cerrar();
        if (actividad==null)
            Toast.makeText(this, "La Actividad " + editNombreActividad.getText().toString() +
                    " no fue encontrada", Toast.LENGTH_LONG).show();
        else {
            editNombreActividad.setText(actividad.getNombre());
        }
    }

    public void limpiarTexto(View v){
        editIdConsultar.setText("");
        editNombreActividad.setText("");
    }
}
