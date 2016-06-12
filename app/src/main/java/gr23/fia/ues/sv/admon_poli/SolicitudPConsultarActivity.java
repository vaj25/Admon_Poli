package gr23.fia.ues.sv.admon_poli;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

@SuppressLint("NewApi")
public class SolicitudPConsultarActivity extends Activity {

    private Spinner estado;
    private ListView listView;
    private Conexion conexion;
    private List<Solicitud> listaSolicitud;
    private final String service = "/AdmonPoli/count_solicitud.php?";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_pconsultar);
        conexion = new Conexion();

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        estado = (Spinner) findViewById(R.id.selectEstado);
        listView = (ListView) findViewById(R.id.listView);

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
        String solicitudJSON = ControlServicio.obtenerRespuestaPeticion(url, this);
        listaSolicitud = ControlServicio.obtenerSolicitudes(solicitudJSON, this);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaSolicitud);
        adaptador.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(adaptador);

    }
}
