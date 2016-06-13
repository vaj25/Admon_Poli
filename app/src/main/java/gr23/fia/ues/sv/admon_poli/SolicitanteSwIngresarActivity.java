package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONObject;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SolicitanteSwIngresarActivity extends Activity {

    EditText duitxt;
    EditText nombretxt;
    EditText apellidotxt;
    EditText telefonotxt;
    EditText emailtxt;

    Conexion conn;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante_sw_ingresar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();
        duitxt = (EditText) findViewById(R.id.dui);
        nombretxt = (EditText) findViewById(R.id.nombreSol);
        apellidotxt = (EditText) findViewById(R.id.apellidoSol);
        telefonotxt = (EditText) findViewById(R.id.telefonosol);
        emailtxt = (EditText) findViewById(R.id.emailsol);

    }

    public void insertarSolicitanteBase(View v) {
        String dui = duitxt.getText().toString();
        String nombre = nombretxt.getText().toString();
        String apellido = apellidotxt.getText().toString();
        String telefono = telefonotxt.getText().toString();
        String email = emailtxt.getText().toString();
        String url = null;
        //JSONObject datosTarifa = new JSONObject();
        //JSONObject tarifa = new JSONObject();
        url=conn.getURLLocal()+"AdmonPoli/ingresar_solicitante.php" + "?dui=" + dui + "&nombresol=" + nombre + "&apellidosol=" + apellido + "&telefonosol=" +  telefono + "&emailsol=" +  email + "&FECHA_MODIFICADO=" + "CURRENT_TIMESTAMP";
        ControlServicio.insertarSolicitantePHP(url, this);


    }
}
