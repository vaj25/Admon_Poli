package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleSolicitudEliminarActivity extends Activity {

    EditText idSolicitud;
    EditText idArea;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_eliminar);

        helper = new ControlBD (this);
        idArea = (EditText)findViewById(R.id.editIdArea);
        idSolicitud = (EditText)findViewById(R.id.editIdSolicitud);
    }

    public void eliminarDetalleSolicitud(View v){
        String regEliminadas;
        DetalleSolicitud ds = new DetalleSolicitud();
        String idsolicitud = idSolicitud.getText().toString();
        String idarea = idArea.getText().toString();
        ds.setIdSolicitud(Integer.parseInt(idsolicitud));
        ds.setIdArea(Integer.parseInt(idarea));
        helper.abrir();
        regEliminadas = helper.eliminar(ds);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
