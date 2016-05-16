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

public class DetalleReservaConsultarActivity extends Activity {
    ControlBD helper;
    EditText idDescripcion;
    Spinner sReserva;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_consultar);
        helper = new ControlBD(this);
        //idDeporte = (EditText) findViewById(R.id.idDeporte);
        //idArea = (EditText) findViewById(R.id.idArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);
        sReserva = (Spinner) findViewById(R.id.selectReserva);
        sArea = (Spinner) findViewById(R.id.selectArea);

        lista = new ArrayList<>();
        lista=helper.consultaArea();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaReserva();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReserva.setAdapter(adaptador1);
    }
    public void consultarDetalleReserva(View v) {
        helper.abrir();
        int position= sArea.getSelectedItemPosition();
        int position1= sReserva.getSelectedItemPosition();
        //int count = helper.count("area");
        Iterator iterador = lista.listIterator();
        Iterator iterador1 = lista1.listIterator();
        int count=0;
        int idarea=0;
        int idreserva=0;
        while( iterador.hasNext() ) {
            Area area = (Area) iterador.next();
            if(count==position){
                idarea=area.getIdArea();
            }
            count++;
        }
        int count1=0;
        while( iterador1.hasNext() ) {
            Reserva reserva = (Reserva) iterador1.next();
            if(count1==position1){
                idreserva=reserva.getIdReserva();
            }
            count1++;
        }
        DetalleReserva da = helper.consultarDetalleReserva(idreserva,idarea);
        helper.cerrar();
        if(da == null)
            Toast.makeText(this, "Deporte-Area no registrado", Toast.LENGTH_LONG).show();
        else{
            idDescripcion.setText(String.valueOf(da.getDescripcion()));
        }
    }
    public void limpiarTexto(View v) {
        idDescripcion.setText("");
    }
}