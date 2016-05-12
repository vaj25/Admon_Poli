package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AreaConsultarActivity extends Activity {
    ControlBD helper;
    EditText idArea;
    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_area_consultar);
        helper = new ControlBD(this);
        idArea = (EditText) findViewById(R.id.idArea);
        nombreArea = (EditText) findViewById(R.id.nombreArea);
        capacidadArea = (EditText) findViewById(R.id.capacidadArea);
        aream2 = (EditText) findViewById(R.id.aream2);
    }
    public void consultarArea(View v) {
        helper.abrir();
        String idarea=idArea.getText().toString();
        Area area = helper.consultarArea(Integer.parseInt(idarea));
        helper.cerrar();
        if(area == null)
            Toast.makeText(this, "Area con Identificador " + idArea.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            nombreArea.setText("Nombre: "+ "\n"+area.getNombre());
            capacidadArea.setText("Capacidad: "+ "\n"+String.valueOf(area.getCapacidad()));
            aream2.setText("Area en m2: "+ "\n"+String.valueOf(area.getArea()));
        }
    }
    public void limpiarTexto(View v){
        idArea.setText("");
        nombreArea.setText("");
        capacidadArea.setText("");
        aream2.setText("");
    }
}



