package gr23.fia.ues.sv.admon_poli;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteActualizarActivity extends Activity {
    ControlBD helper;
    EditText idDeporte;
    EditText nombreDeporte;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_actualizar);
        helper = new ControlBD(this);
        idDeporte = (EditText) findViewById(R.id.idDeporte);
        nombreDeporte = (EditText) findViewById(R.id.nombreDeporte);

    }
    public void actualizarDeporte(View v) {
        Deporte deporte = new Deporte();
        String iddeporte=idDeporte.getText().toString();
        deporte.setIdDeporte(Integer.parseInt(iddeporte));
        deporte.setNombre(nombreDeporte.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(deporte);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idDeporte.setText("");
        nombreDeporte.setText("");

    }
}
