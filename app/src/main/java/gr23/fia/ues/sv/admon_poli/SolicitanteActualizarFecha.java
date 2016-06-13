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
public class SolicitanteActualizarFecha extends Activity {

    ControlBD db;
    Conexion conn;
    static List<Solicitante> listaSolicitante;
    static List<String> nombreSolicitante;
    EditText fechaTxt;
    ListView listView;
    TextView texto1;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante_actualizar_fecha);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new ControlBD(this);
        conn=new Conexion();
        listaSolicitante = new ArrayList<Solicitante>();
        nombreSolicitante = new ArrayList<String>();
        fechaTxt = (EditText) findViewById(R.id.fechasoli);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void Guardar(View v) {
        String[] fecha = fechaTxt.getText().toString().split("-");
        String url="";

        url =conn.getURLLocal()+"/AdmonPoli/consultar_solicitante_fecha.php" + "?year=" + fecha[0] + "&month="+ fecha[1] + "&day=" + fecha[2];

        String solicitanteExterno ="";
        solicitanteExterno = ControlServicio.obtenerRespuestaPeticion(url,this);
        try {listaSolicitante.addAll(ControlServicio.obtenerSolicitanteExterno(solicitanteExterno, this));
            actualizarListView();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        db.abrir();
        for(int i=0; i < listaSolicitante.size();i++){
            Log.v("guardar", db.insertar(listaSolicitante.get(i)));
        }
        db.cerrar();

        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_LONG).show();
        actualizarListView();
        listaSolicitante.removeAll(listaSolicitante);
    }

    private void actualizarListView() {
        String dato;
        nombreSolicitante.clear();
        for (int i = 0; i < listaSolicitante.size(); i++) {
            dato = listaSolicitante.get(i).getDui() ;
            nombreSolicitante.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreSolicitante);
        listView.setAdapter(adaptador);
    }

    private void eliminarElementosDuplicados() {
        HashSet<Solicitante> conjuntoSol = new HashSet<Solicitante>();
        conjuntoSol.addAll(listaSolicitante);
        listaSolicitante.clear();
        listaSolicitante.addAll(conjuntoSol);
        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreSolicitante);
        nombreSolicitante.clear();
        nombreSolicitante.addAll(conjuntoNombre);
    }

}

