package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteAreaConsultarActivity extends Activity {
    ControlBD helper;
    EditText idDeporte;
    EditText idArea;
    EditText idDescripcion;
    EditText idActivo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_consultar);
        helper = new ControlBD(this);
        idDeporte = (EditText) findViewById(R.id.idDeporte);
        idArea = (EditText) findViewById(R.id.idArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);
    }
    public void consultarDeporteArea(View v) {
        helper.abrir();
        DeporteArea da = helper.consultarDeporteArea(Integer.parseInt(idDeporte.getText().toString()),
                Integer.parseInt(idArea.getText().toString()));
        helper.cerrar();
        if(da == null)
            Toast.makeText(this, "Deporte-Area no registrado", Toast.LENGTH_LONG).show();
        else{
            idDescripcion.setText(String.valueOf(da.getDescripcion()));
            idActivo.setText(String.valueOf(da.isActivo()));
        }
    }
    public void limpiarTexto(View v) {
        idDeporte.setText("");
        idArea.setText("");
        idDescripcion.setText("");
        idActivo.setText("");
    }
}