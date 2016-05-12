package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleSolicitudConsultarActivity extends Activity {

    ControlBD helper;
    EditText idSolicitud;
    EditText idArea;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_consultar);

        helper = new ControlBD(this);
        idSolicitud = (EditText) findViewById(R.id.editIdSolicitud);
        idArea = (EditText) findViewById(R.id.editIdArea);
        descripcion = (EditText) findViewById(R.id.editDescripcion);
    }

    public void consultarDetalleSolicitud(View v){
        helper.abrir();
        String idsolicitud = idSolicitud.getText().toString();
        String idarea = idArea.getText().toString();
        DetalleSolicitud ds = helper.consultarDS(Integer.parseInt(idsolicitud), Integer.parseInt(idarea));
        helper.cerrar();
        if(ds == null)
            Toast.makeText(this, "Solicitud con Id " + idSolicitud.getText().toString() +
                    " y Area con Id "+ idArea.getText().toString() +"no encontrado" , Toast.LENGTH_LONG).show();
        else{
            descripcion.setText("Solicitud asignada a un Area");
        }
    }

    public void limpiarTexto(View v) {
        idSolicitud.setText("");
        idArea.setText("");
    }
}
