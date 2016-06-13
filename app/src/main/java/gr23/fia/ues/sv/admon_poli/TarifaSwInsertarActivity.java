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
public class TarifaSwInsertarActivity extends Activity {

    EditText idtarifatxt;
    EditText preciotxt;
    EditText canthoratxt;
    EditText cantpersonatxt;

    Conexion conn;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_sw_insertar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();
        idtarifatxt = (EditText) findViewById(R.id.idtarifa);
        preciotxt = (EditText) findViewById(R.id.tarPrecio);
        canthoratxt = (EditText) findViewById(R.id.cantHora);
        cantpersonatxt = (EditText) findViewById(R.id.cantPersona);
    }

    public void insertarTarifaBase(View v) {
        String idtarifa = idtarifatxt.getText().toString();
        String precio = preciotxt.getText().toString();
        String canthora = canthoratxt.getText().toString();
        String cantpersona = cantpersonatxt.getText().toString();
        String url = null;
        //JSONObject datosTarifa = new JSONObject();
        //JSONObject tarifa = new JSONObject();
        url=conn.getURLLocal()+"/AdmonPoli/ws_tarifa_insert.php" + "?idtarifa=" + idtarifa + "&precio=" + precio + "&canthora=" + canthora + "&cantpersona=" +  cantpersona + "&fecha_modificado=" + "CURRENT_TIMESTAMP";
        ControlServicio.insertarTarifaPHP(url, this);


    }
}
