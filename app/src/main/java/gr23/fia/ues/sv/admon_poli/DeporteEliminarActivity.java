package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeporteEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sDeporte;
    List<String> lista;
    List<String> lista1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_eliminar);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);
        helper=new ControlBD (this);
        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);
    }

    public void eliminarDeporte(View v){
        int position1= sDeporte.getSelectedItemPosition();
        Iterator iterador1 = lista1.listIterator();
        int iddeporte=0;
        int count1=0;
        while( iterador1.hasNext() ) {
            Deporte dep = (Deporte) iterador1.next();
            if(count1==position1){
                iddeporte=dep.getIdDeporte();
            }
            count1++;
        }
        String regEliminadas;
        Deporte deporte=new Deporte();
        deporte.setIdDeporte(iddeporte);
        helper.abrir();
        regEliminadas=helper.eliminar(deporte);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
