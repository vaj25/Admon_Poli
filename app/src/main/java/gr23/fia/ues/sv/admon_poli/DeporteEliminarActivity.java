package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteEliminarActivity extends Activity {
    EditText IdDeporte;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_eliminar);
        controlhelper=new ControlBD (this);
        IdDeporte=(EditText)findViewById(R.id.iddeporte);
    }
    public void eliminarDeporte(View v){
        String regEliminadas;
        Deporte deporte=new Deporte();
        String iddeporte=IdDeporte.getText().toString();
        deporte.setIdDeporte(Integer.getInteger(iddeporte));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(deporte);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}