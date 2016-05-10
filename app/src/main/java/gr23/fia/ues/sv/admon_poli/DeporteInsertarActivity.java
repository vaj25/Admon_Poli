package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteInsertarActivity extends Activity {
    ControlBD helper;
    EditText IdDeporte;
    EditText NombreDeporte;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_deporte_insertar);
        helper = new ControlBD(this);
        IdDeporte = (EditText) findViewById(R.id.IdDeporte);
        NombreDeporte = (EditText) findViewById(R.id.NombreDeporte);
    }
    public void insertarDeporte(View v) {
        String iddeporte=IdDeporte.getText().toString();
        String nombre=NombreDeporte.getText().toString();
        String regInsertados;
        Deporte deporte=new Deporte();
        deporte.setIdDeporte(Integer.getInteger(iddeporte));
        deporte.setNombre(nombre);
        helper.abrir();
        regInsertados=helper.insertar(deporte);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        IdDeporte.setText("");
        NombreDeporte.setText("");
    }
}