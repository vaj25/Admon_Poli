package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AreaEliminarActivity extends Activity {
    EditText idArea;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_eliminar);
        controlhelper=new ControlBD (this);
        idArea=(EditText)findViewById(R.id.idArea);
    }
    public void eliminarArea(View v){
        String regEliminadas;
        Area area=new Area();
        String idarea=idArea.getText().toString();
        area.setIdArea(Integer.parseInt(idarea));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(area);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
