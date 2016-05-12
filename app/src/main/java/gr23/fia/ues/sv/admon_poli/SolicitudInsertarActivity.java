package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;

public class SolicitudInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText idSolicitud;
    EditText fechaSolicitud;
    EditText cantAsistentes;
    EditText montoArea;
    EditText area;
    Spinner actividad;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_insertar);
        helper = new ControlBD(this);

        actividad = (Spinner) findViewById(R.id.selectActividad) ;

        LinkedList acts = new LinkedList();
        helper.abrir();
        int count = helper.count("actividad");
        for(int i = 1; i<=count; i++){
            Actividad act = helper.consultarActividad(i) ;
            acts.add(new Actividad(act.getIdActividad(), act.getNombre()));
        }
        ArrayAdapter spinner_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, acts);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actividad.setAdapter(spinner_adapter);
    }

    /*public void insertarDeporte(View v) {
        String iddeporte=IdDeporte.getText().toString();
        String nombre=NombreDeporte.getText().toString();
        String regInsertados;
        Deporte deporte=new Deporte();
        deporte.setIdDeporte(Integer.parseInt(iddeporte));
        deporte.setNombre(nombre);
        helper.abrir();
        regInsertados=helper.insertar(deporte);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        IdDeporte.setText("");
        NombreDeporte.setText("");
    }*/
}
