package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleSolicitudActualizarActivity extends Activity {

    ControlBD helper;
    EditText idSolicitud;
    EditText idArea;
    EditText idSolicitudNueva;
    EditText idAreaNueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_actualizar);

        helper = new ControlBD(this);
        idSolicitud = (EditText) findViewById(R.id.editIdSolicitud);
        idArea = (EditText) findViewById(R.id.editIdArea);
        idSolicitudNueva = (EditText) findViewById(R.id.editIdSolicitudNueva);
        idAreaNueva = (EditText) findViewById(R.id.editIdAreaNueva);
    }

    public void actualizarDetalleSolicitud(View v) {
        DetalleSolicitud ds = new DetalleSolicitud();
        Integer idsolicitud = Integer.parseInt(idSolicitud.getText().toString());
        Integer idarea = Integer.parseInt(idArea.getText().toString());
        ds.setIdSolicitud(idsolicitud);
        ds.setIdArea(idarea);

        DetalleSolicitud ds1 = new DetalleSolicitud();
        Integer idsolicitudn = Integer.parseInt(idSolicitudNueva.getText().toString());
        Integer idarean = Integer.parseInt(idAreaNueva.getText().toString());
        ds1.setIdSolicitud(idsolicitud);
        ds1.setIdArea(idarea);

        helper.abrir();
        String estado = helper.eliminar(ds);
        String estado2 = helper.insertar(ds1);

        helper.cerrar();
        Toast.makeText(this, "Item Actualizado", Toast.LENGTH_SHORT).show();
    }

}
