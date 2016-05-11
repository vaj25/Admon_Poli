package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeporteAreaInsertarActivity extends Activity {
    ControlBD helper;
    EditText idDeporte;
    EditText idArea;
    EditText idDescripcion;
    EditText idActivo;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_insertar);
        helper = new ControlBD(this);
        idDeporte = (EditText) findViewById(R.id.idDeporte);
        idArea = (EditText) findViewById(R.id.idArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);
    }
    public void insertarDeporteArea(View v) {
        String regInsertados;
        Integer iddeporte=Integer.parseInt(idDeporte.getText().toString());
        Integer idarea=Integer.parseInt(idArea.getText().toString());
        String iddescripcion=idDescripcion.getText().toString();
        String idactivo=idActivo.getText().toString();
        DeporteArea da= new DeporteArea();
        da.setIdDeporte(iddeporte);
        da.setIdArea(idarea);
        da.setDescripcion(iddescripcion);
        da.setActivo(idactivo);
        helper.abrir();
        regInsertados=helper.insertar(da);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idDeporte.setText("");
        idArea.setText("");
        idDescripcion.setText("");
        idActivo.setText("");
    }
}
