package gr23.fia.ues.sv.admon_poli;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.List;

@SuppressLint("NewApi")
public class SolicitudesPorActividadActivity extends Activity {

    private Spinner actividad;
    private ListView listView;
    private Conexion conexion;
    private List<Solicitud> listaSolicitud;
    private final String service = "/AdmonPoli/ws_cant_sol_actividad.php?";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_por_actividad);
        conexion = new Conexion();

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        actividad = (Spinner) findViewById(R.id.selectActividad);
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.actividades,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actividad.setAdapter(adapter);
    }

    public void consultarSolicitud2(View v){
        int idactividad=0;
        idactividad=actividad.getSelectedItemPosition()+1;

        String url = conexion.getURLLocal() + service + "idactividad=" + idactividad;
        String solicitudJSON = ControlServicio.obtenerRespuestaPeticion(url, this);
        listaSolicitud = ControlServicio.obtenerSolicitudes(solicitudJSON, this);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaSolicitud);
        adaptador.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(adaptador);

    }
}