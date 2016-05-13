package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class DeporteAreaInsertarActivity extends AppCompatActivity {
    ControlBD helper;
   // EditText idDeporte;
    //EditText idArea;
    EditText idDescripcion;
    EditText idActivo;
    Spinner sDeporte;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_insertar);
        helper = new ControlBD(this);
        //idDeporte = (EditText) findViewById(R.id.idDeporte);
        //idArea = (EditText) findViewById(R.id.idArea);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);
        sArea = (Spinner) findViewById(R.id.selectArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        idActivo = (EditText) findViewById(R.id.idActivo);

        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);

    }
    public void insertarDeporteArea(View v) {
        String regInsertados;
        //Integer iddeporte=Integer.parseInt(idDeporte.getText().toString());
        //Integer idarea=Integer.parseInt(idArea.getText().toString());
        String iddescripcion=idDescripcion.getText().toString();
        String idactivo=idActivo.getText().toString();
        DeporteArea da= new DeporteArea();

        da.setIdDeporte(sDeporte.getLastVisiblePosition());
        da.setIdArea(sArea.getLastVisiblePosition());
        da.setDescripcion(iddescripcion);
        da.setActivo(idactivo);
        helper.abrir();
        regInsertados=helper.insertar(da);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idDescripcion.setText("");
        idActivo.setText("");
    }
}
