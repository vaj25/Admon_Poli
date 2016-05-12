package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleSolicitudInsertarActivity extends Activity {

    ControlBD helper;
    EditText idSolicitud;
    EditText idArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud_insertar);

        helper = new ControlBD(this);

        idSolicitud = (EditText) findViewById(R.id.editIdSolicitud) ;
        idArea = (EditText) findViewById(R.id.editIdArea) ;

    }


    public void insertarDetalleSolicitud(View v) {

        String idsolicitud = idSolicitud.getText().toString();
        String idarea = idArea.getText().toString();
        String regInsertados;
        DetalleSolicitud desolt = new DetalleSolicitud();
        desolt.setIdSolicitud(Integer.parseInt(idsolicitud));
        desolt.setIdArea(Integer.parseInt(idarea));

        helper.abrir();
        regInsertados=helper.insertar(desolt);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        idSolicitud.setText("");
        idArea.setText("");
    }

}
