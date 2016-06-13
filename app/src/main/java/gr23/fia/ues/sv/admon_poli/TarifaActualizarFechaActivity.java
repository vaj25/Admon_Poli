package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import android.os.Bundle;
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
public class TarifaActualizarFechaActivity extends Activity {

    ControlBD db;
    Conexion conn;
    static List<Tarifa> listaTarifa;
    static List<String> nombreTarifa;
    EditText fechaTxt;
    ListView listViewTarifa;
    TextView texto1;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_actualizar_fecha);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new ControlBD(this);
        conn=new Conexion();
        listaTarifa = new ArrayList<Tarifa>();
        nombreTarifa = new ArrayList<String>();
        fechaTxt = (EditText) findViewById(R.id.fecha);
        listViewTarifa = (ListView) findViewById(R.id.listView1);
        //texto1 = (TextView) findViewById(R.id.textView1);
        //valor default
        //fechaTxt.setText("01/01/2016");

    }


    public void guardar(View v) {
        String[] fecha = fechaTxt.getText().toString().split("/");
        String url="";
        url =conn.getURLLocal()+"/AdmonPoli/ws_tarifa_fecha.php" + "?day=" + fecha[0] + "&month="+ fecha[1] + "&year=" + fecha[2];
        String tarifaExternas ="";
        tarifaExternas = ControlServicio.obtenerRespuestaPeticion(url,this);
        try {listaTarifa.addAll(ControlServicio.obtenerTarifaExterno(tarifaExternas, this));
            actualizarListView();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        db.abrir();
        for(int i=0; i < listaTarifa.size();i++){
            Log.v("guardar",db.insertar(listaTarifa.get(i)));
        }
        db.cerrar();
        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_LONG).show();
        actualizarListView();
        listaTarifa.removeAll(listaTarifa);
    }

    private void actualizarListView() {
        String dato = "";
        nombreTarifa.clear();
        for (int i = 0; i < listaTarifa.size(); i++) {
            dato = listaTarifa.get(i).getIdTarifa() + " " + listaTarifa.get(i).getPrecio();
            nombreTarifa.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreTarifa);
        listViewTarifa.setAdapter(adaptador);
    }
    private void eliminarElementosDuplicados() {
        HashSet<Tarifa> conjuntoTarifa = new HashSet<Tarifa>();
        conjuntoTarifa.addAll(listaTarifa);
        listaTarifa.clear();
        listaTarifa.addAll(conjuntoTarifa);
        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreTarifa);
        nombreTarifa.clear();
        nombreTarifa.addAll(conjuntoNombre);
    }

}
