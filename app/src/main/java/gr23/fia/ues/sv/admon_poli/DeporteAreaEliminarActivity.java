package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class DeporteAreaEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sDeporte;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_area_eliminar);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);
        sArea = (Spinner) findViewById(R.id.selectArea);
        helper=new ControlBD (this);
        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);
    }
    public void eliminarDeporteArea(View v){
        String regEliminadas;
        DeporteArea da=new DeporteArea();
        da.setIdDeporte(sDeporte.getSelectedItemPosition()+1);
        da.setIdArea(sArea.getSelectedItemPosition()+1);
        helper.abrir();
        regEliminadas=helper.eliminar(da);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
