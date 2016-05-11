package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteConsultarActivity extends Activity {
    ControlBD helper;
    EditText idDeporte;
    EditText nombreDeporte;
      /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_deporte_consultar);
        helper = new ControlBD(this);
        idDeporte = (EditText) findViewById(R.id.idDeporte);
        nombreDeporte = (EditText) findViewById(R.id.nombreDeporte);
    }
    public void consultarDeporte(View v) {
        helper.abrir();
        String iddeporte=idDeporte.getText().toString();
        Deporte deporte = helper.consultarDeporte(Integer.parseInt(iddeporte));
        helper.cerrar();
        if(deporte == null)
            Toast.makeText(this, "Deporte con Id " + idDeporte.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            nombreDeporte.setText(deporte.getNombre());
            }
    }
    public void limpiarTexto(View v){
        idDeporte.setText("");
        nombreDeporte.setText("");
            }
}


