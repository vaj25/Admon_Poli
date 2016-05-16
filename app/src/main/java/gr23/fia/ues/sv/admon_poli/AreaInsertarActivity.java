package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AreaInsertarActivity extends Activity {

    ControlBD helper;
    EditText idArea;
    EditText nombreArea;
    EditText capacidadArea;
    EditText aream2;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_insertar);
        helper = new ControlBD(this);
        nombreArea = (EditText) findViewById(R.id.nombreArea);
        capacidadArea = (EditText) findViewById(R.id.capacidadArea);
        aream2 = (EditText) findViewById(R.id.aream2);
    }

    public void insertarArea(View v) {

        int idarea=helper.contarRegistros("area","idarea");
        String nombrearea=nombreArea.getText().toString();
        String capacidadarea=capacidadArea.getText().toString();
        String aream=aream2.getText().toString();
        String regInsertados;
        Area area=new Area();
        area.setIdArea(idarea);
        area.setNombre(nombrearea);
        area.setCapacidad(Integer.parseInt(capacidadarea));
        area.setArea(Float.parseFloat(aream));
        helper.abrir();
        regInsertados=helper.insertar(area);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        nombreArea.setText("");
        capacidadArea.setText("");
        aream2.setText("");
    }
}