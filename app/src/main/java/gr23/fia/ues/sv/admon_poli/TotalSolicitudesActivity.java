package gr23.fia.ues.sv.admon_poli;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi")
public class TotalSolicitudesActivity extends Activity {

    private EditText total;
    private Conexion conexion;
    private final String service = "/AdmonPoli/ws_monto_tarifas.php?";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_solicitudes);
        conexion = new Conexion();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        total = (EditText) findViewById(R.id.monto);
    }

    public void consultarSolicitud3(View v){

        String url = conexion.getURLLocal() + service;
        String solicitudJSON = ControlServicio.obtenerRespuestaPeticion(url, this);
        Toast.makeText(this, solicitudJSON, Toast.LENGTH_SHORT).show();
        total.setText("Total calculado $"+ControlServicio.sumaTarifasJSON(solicitudJSON, this));

    }
}
