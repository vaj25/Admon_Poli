package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class DeporteAreaEliminarActivity extends Activity {
    EditText idDeporte;
    EditText idArea;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_eliminar);
        controlhelper=new ControlBD (this);
        idArea=(EditText)findViewById(R.id.idArea);
        idDeporte=(EditText)findViewById(R.id.idDeporte);
    }
    public void eliminarDeporteArea(View v){
        String regEliminadas;
        DeporteArea da=new DeporteArea();
        String iddeporte=idDeporte.getText().toString();
        String idarea=idArea.getText().toString();
        da.setIdDeporte(Integer.parseInt(iddeporte));
        da.setIdArea(Integer.parseInt(idarea));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(da);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
