package gr23.fia.ues.sv.admon_poli;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TarifaConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    List<Tarifa> lista ;
    EditText EditMonto;
    EditText EditHorasTarifa;
    EditText EditPersonasTarifa;
    EditText EditmontoTarifa;
    Spinner idTarifa ;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_consultar);
        helper=new ControlBD(this);

        EditMonto=(EditText)findViewById(R.id.editText16);
        EditHorasTarifa=(EditText)findViewById(R.id.cantHorasTarifa);
        EditPersonasTarifa=(EditText)findViewById(R.id.cantidadPersonasTarifa);
        EditmontoTarifa=(EditText)findViewById(R.id.montoTarifa);
        idTarifa = (Spinner) findViewById(R.id.spinnerConsultar) ;

        lista = new ArrayList<>();
        lista=helper.consultaTarifa();

        ArrayAdapter<Tarifa> adaptador =new ArrayAdapter<Tarifa>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idTarifa.setAdapter(adaptador);
    }

    public void consultarTarifa(View v){
        helper.abrir();
        Tarifa tarifa = helper.consultarTarifa(idTarifa.getSelectedItemPosition()+1);

        helper.cerrar();

        if(tarifa==null){
            Toast.makeText(this,"Tarifa no registrada", Toast.LENGTH_LONG).show();
        }else{
            EditmontoTarifa.setText(String.valueOf(tarifa.getPrecio()));
            EditPersonasTarifa.setText(String.valueOf(tarifa.getCantPersonas()));
            EditHorasTarifa.setText(String.valueOf(tarifa.getCanthora()));

        }
    }
    public void limpiarTexto(View v) {
        EditHorasTarifa.setText("") ;
        EditPersonasTarifa.setText("") ;
        EditmontoTarifa.setText("") ;

    }

}









