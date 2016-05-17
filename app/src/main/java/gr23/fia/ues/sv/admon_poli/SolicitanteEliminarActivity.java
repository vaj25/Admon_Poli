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

public class SolicitanteEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sSolicitante;
    List<String> lista;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante_eliminar);
        helper=new ControlBD (this);
        sSolicitante = (Spinner) findViewById(R.id.SelectSolicitante);

        lista = new ArrayList<>();
        lista=helper.consultaSolicitante();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSolicitante.setAdapter(adaptador);

    }
    public void eliminarSolicitante(View v){
        int position= sSolicitante.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        String idsolicitante="";
        while( iterador.hasNext() ) {
            Solicitante sol = (Solicitante) iterador.next();
            if(count==position){
                idsolicitante=sol.getDui();
            }
            count++;
        }
        int regEliminadas;
        Solicitante soli=new Solicitante();
        soli.setDui(idsolicitante);
        helper.abrir();
        regEliminadas=helper.eliminar(soli);
        helper.cerrar();
        Toast.makeText(this,"filas afectadas="+ regEliminadas, Toast.LENGTH_SHORT).show();
    }
}