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

public class DetalleReservaEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sReserva;
    Spinner sArea;
    List<String> lista;
    List<String> lista1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva_eliminar);
        sReserva = (Spinner) findViewById(R.id.selectReserva);
        sArea = (Spinner) findViewById(R.id.selectArea);
        helper=new ControlBD (this);

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

    public void eliminarDetalleReserva(View v){
        int position= sArea.getSelectedItemPosition();
        int position1= sReserva.getSelectedItemPosition();
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
            Reserva dep = (Reserva) iterador1.next();
            if(count1==position1){
                idreserva=dep.getIdReserva();
            }
            count1++;
        }
        String regEliminadas;
        DetalleReserva dr=new DetalleReserva();
        dr.setIdReserva(idreserva);
        dr.setIdArea(idarea);
        helper.abrir();
        regEliminadas=helper.eliminar(dr);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}