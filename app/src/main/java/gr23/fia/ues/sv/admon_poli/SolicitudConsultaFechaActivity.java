package gr23.fia.ues.sv.admon_poli;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SolicitudConsultaFechaActivity extends Activity {

    ControlBD db;
    Conexion conn;
    static List<Solicitud> listaSolicitud;
    static List<String> nombreSolicitud;
    EditText fechaTxt;
    ListView listViewSolicitud;
    TextView texto1;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_consulta_fecha);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new ControlBD(this);
        conn=new Conexion();
        listaSolicitud = new ArrayList<Solicitud>();
        nombreSolicitud = new ArrayList<String>();
        fechaTxt = (EditText) findViewById(R.id.fecha);
        listViewSolicitud = (ListView) findViewById(R.id.listView1);
        //texto1 = (TextView) findViewById(R.id.textView1);
        //valor default
        //fechaTxt.setText("01/01/2016");

    }
    public void guardar(View v) {
        String[] fecha = fechaTxt.getText().toString().split("/");
        String url="";
        url =conn.getURLLocal()+"/AdmonPoli/ws_fecha_solicitud.php" + "?day=" + fecha[0] + "&month="+ fecha[1] + "&year=" + fecha[2];
        String soliExternas ="";
        soliExternas = ControlServicio.obtenerRespuestaPeticion(url,this);
        try {listaSolicitud.addAll(ControlServicio.obtenerSolicitudExterno(soliExternas, this));
            actualizarListView();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        db.abrir();
        for(int i=0; i < listaSolicitud.size();i++){
            Log.v("guardar",db.insertar(listaSolicitud.get(i)));
        }
        db.cerrar();
        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_LONG).show();
        listaSolicitud.removeAll(listaSolicitud);
        actualizarListView();
    }

    private void actualizarListView() {
        String dato = "";
        nombreSolicitud.clear();
        for (int i = 0; i < listaSolicitud.size(); i++) {
            dato = listaSolicitud.get(i).getIdSolicitud() + " " + listaSolicitud.get(i).getFechaReserva();
            nombreSolicitud.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreSolicitud);
        listViewSolicitud.setAdapter(adaptador);
    }
    private void eliminarElementosDuplicados() {
        HashSet<Solicitud> conjuntoTarifa = new HashSet<Solicitud>();
        conjuntoTarifa.addAll(listaSolicitud);
        listaSolicitud.clear();
        listaSolicitud.addAll(conjuntoTarifa);
        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreSolicitud);
        nombreSolicitud.clear();
        nombreSolicitud.addAll(conjuntoNombre);
    }
}

