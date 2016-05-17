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

public class ReservaEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sReserva;
    List<String> lista;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_eliminar);
        helper=new ControlBD (this);
        sReserva = (Spinner) findViewById(R.id.selectReserva);

        lista = new ArrayList<>();
        lista=helper.consultaReserva();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReserva.setAdapter(adaptador);

    }
    public void eliminarReserva(View v){
        int position= sReserva.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idreserva=0;
        while( iterador.hasNext() ) {
            Reserva reserv = (Reserva) iterador.next();
            if(count==position){
                idreserva=reserv.getIdReserva();
            }
            count++;
        }
        int regEliminadas;
        Reserva reserva=new Reserva();
        reserva.setIdReserva(idreserva);
        helper.abrir();
        regEliminadas=helper.eliminar(reserva);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}