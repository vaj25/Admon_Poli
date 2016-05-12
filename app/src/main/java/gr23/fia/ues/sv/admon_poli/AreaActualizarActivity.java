package gr23.fia.ues.sv.admon_poli;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AreaActualizarActivity extends Activity {
    ControlBD helper;
    EditText idArea;
    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_actualizar);
        helper = new ControlBD(this);
        idArea = (EditText) findViewById(R.id.idArea);
        nombreArea = (EditText) findViewById(R.id.nombreArea);
        capacidadArea = (EditText) findViewById(R.id.capacidadArea);
        aream2 = (EditText) findViewById(R.id.aream2);

    }
    public void actualizarArea(View v) {
        Area area = new Area();
        String idarea=idArea.getText().toString();
        area.setIdArea(Integer.parseInt(idarea));
        area.setNombre(nombreArea.getText().toString());
        String capacidadarea=capacidadArea.getText().toString();
        area.setCapacidad(Integer.parseInt(capacidadarea));
        String aream=aream2.getText().toString();
        area.setArea(Float.parseFloat(aream));
        helper.abrir();
        String estado = helper.actualizar(area);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idArea.setText("");
        nombreArea.setText("");
        capacidadArea.setText("");
        aream2.setText("");

    }
}
