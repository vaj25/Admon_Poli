package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteAreaActualizarActivity extends Activity {
    ControlBD helper;
    EditText idDeporte;
    EditText idArea;
    EditText idDescripcion;
    EditText idActivo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_actualizar);
        helper = new ControlBD(this);
        idDeporte = (EditText) findViewById(R.id.idDeporte);
        idArea = (EditText) findViewById(R.id.idArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);;
    }
    public void actualizarDeporteArea(View v) {
        DeporteArea da = new DeporteArea();
        Integer iddeporte=Integer.parseInt(idDeporte.getText().toString());
        Integer idarea=Integer.parseInt(idArea.getText().toString());
        String iddescripcion=idDescripcion.getText().toString();
        String idactivo=idActivo.getText().toString();
        da.setIdDeporte(iddeporte);
        da.setIdArea(idarea);
        da.setDescripcion(iddescripcion);
        da.setActivo(idactivo);
        helper.abrir();
        String estado = helper.actualizar(da);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        idDeporte.setText("");
        idArea.setText("");
        idDescripcion.setText("");
        idActivo.setText("");
    }
}
