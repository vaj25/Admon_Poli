package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class SolicitudEliminarActivity extends Activity {

    EditText idSolicitud ;
    ControlBD helper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_eliminar);
        helper = new ControlBD(this);
        idSolicitud = (EditText) findViewById(R.id.txtIdSolicitud) ;
    }

    public void eliminarSolicitud(View v){
        String regEliminadas;
        Solicitud solicitud = new Solicitud();
        String idsolicitud = idSolicitud.getText().toString();
        solicitud.setIdSolicitud(Integer.parseInt(idsolicitud));
        helper.abrir();
        regEliminadas = helper.eliminar(solicitud);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
