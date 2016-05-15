package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeporteConsultarActivity extends Activity {
    ControlBD helper;
    EditText idNombre;
    Spinner sDeporte;
    List<String> lista1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte_consultar);
        helper = new ControlBD(this);
        idNombre = (EditText) findViewById(R.id.nombreDeporte);
        sDeporte = (Spinner) findViewById(R.id.selectDeporte);

        lista1 =new ArrayList<>();
        lista1=helper.consultaDeporte();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDeporte.setAdapter(adaptador1);
    }
    public void consultarDeporte(View v) {
        helper.abrir();
        int position1= sDeporte.getSelectedItemPosition();
        Iterator iterador1 = lista1.listIterator();
        int iddeporte=0;
        int count1=0;
        while( iterador1.hasNext() ) {
            Deporte deporte = (Deporte) iterador1.next();
            if(count1==position1){
                iddeporte=deporte.getIdDeporte();
            }
            count1++;
        }
        Deporte deporte = helper.consultarDeporte(iddeporte);
        helper.cerrar();
        if(deporte == null)
            Toast.makeText(this, "Deporte-Area no registrado", Toast.LENGTH_LONG).show();
        else{
            idNombre.setText(String.valueOf(deporte.getNombre()));
            }
    }
    public void limpiarTexto(View v) {
        idNombre.setText("");

    }
}