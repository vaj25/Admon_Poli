package gr23.fia.ues.sv.admon_poli;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetalleReservaInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText idDescripcion;
    Spinner sReserva;
    Spinner sArea;
    List<Reserva> lista;
    List<Area> lista1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_insertar);
        helper = new ControlBD(this);
        sReserva = (Spinner) findViewById(R.id.selectReserva);
        sArea = (Spinner) findViewById(R.id.selectArea);
        idDescripcion = (EditText) findViewById(R.id.idDescripcion);

        lista = new ArrayList<>();
        lista=helper.consultaReserva();
        ArrayAdapter<Reserva> adaptador =new ArrayAdapter<Reserva>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReserva.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaArea();
        ArrayAdapter<Area> adaptador1 =new ArrayAdapter<Area>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sArea.setAdapter(adaptador1);
    }
    public void insertarDetalleReserva(View v) {
        String regInsertados;
        String iddescripcion=idDescripcion.getText().toString();
        DetalleReserva dr= new DetalleReserva();
        int position= sReserva.getSelectedItemPosition();
        int position1= sArea.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        Iterator iterador1 = lista1.listIterator();

        int count=0;
        int idarea=0;
        int idreserva=0;
        while( iterador.hasNext() ) {
            Reserva reserva = (Reserva) iterador.next();
            if(count==position){
                idreserva=reserva.getIdReserva();
            }
            count++;
        }
        int count1=0;
        while( iterador1.hasNext() ) {
            Area ar = (Area) iterador1.next();
            if(count1==position1){
                idarea=ar.getIdArea();
            }
            count1++;
        }
        dr.setIdReserva(idreserva);
        dr.setIdArea(idarea);
        dr.setDescripcion(iddescripcion);

        helper.abrir();
        regInsertados=helper.insertar(dr);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idDescripcion.setText("");
    }
}