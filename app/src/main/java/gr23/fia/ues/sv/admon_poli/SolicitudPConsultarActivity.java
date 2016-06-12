package gr23.fia.ues.sv.admon_poli;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SolicitudPConsultarActivity extends Activity {

    private EditText resultado;
    private Spinner estado;
    private Conexion conexion;
    private final String service = "/AdmonPoli/count_solicitud.php?";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_pconsultar);
        conexion = new Conexion();

        estado = (Spinner) findViewById(R.id.selectEstado);
        resultado = (EditText) findViewById(R.id.resultado);

        resultado = (EditText) findViewById(R.id.resultado);
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,R.array.estados,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(adapter);
    }

    public void consultarSolicitud(View v){
        String [] estados = getResources().getStringArray(R.array.estados);
        String es = "";
        for (int i=0; i<3; i++) {
            if(estado.getSelectedItemPosition() == i){
                es = estados[i] ;
            }
        }
        String url = conexion.getURLLocal() + service + "estado=" + es;
        String tarifaActualizada = ControlServicio.obtenerRespuestaPeticion(url, this);
        Toast.makeText(this, tarifaActualizada, Toast.LENGTH_LONG).show();
    }
}
