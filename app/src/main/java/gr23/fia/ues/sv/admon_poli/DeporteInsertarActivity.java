package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class DeporteInsertarActivity extends Activity {

    ControlBD helper;
    EditText IdDeporte;
    EditText NombreDeporte;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_insertar);
        helper = new ControlBD(this);
        IdDeporte = (EditText) findViewById(R.id.IdDeporte);
        NombreDeporte = (EditText) findViewById(R.id.NombreDeporte);
    }

    public void insertarDeporte(View v) {
        int iddeporte=helper.contarRegistros("deporte","iddeporte");
        String nombre=NombreDeporte.getText().toString();
        String regInsertados;
        Deporte deporte=new Deporte();
        deporte.setIdDeporte(iddeporte);
        deporte.setNombre(nombre);
        helper.abrir();
        regInsertados=helper.insertar(deporte);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        NombreDeporte.setText("");
    }
}