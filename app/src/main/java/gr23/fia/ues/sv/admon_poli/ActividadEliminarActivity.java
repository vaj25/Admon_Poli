package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadEliminarActivity extends Activity {
    EditText editId;
    ControlBD controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_eliminar);
        controlhelper= new ControlBD(this);
        editId=(EditText)findViewById(R.id.editIdEliminar);
    }

    public void eliminarActividad(View v){

        String regEliminadas;
        Actividad actividad= new Actividad();
        actividad.setIdActividad(Integer.parseInt(editId.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(actividad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
