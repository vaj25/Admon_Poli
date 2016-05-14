package gr23.fia.ues.sv.admon_poli;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    String[] menu={"Tabla Actividad","Tabla Administrador","Tabla Area","Tabla Deporte","Tabla DeporteArea",
            "Tabla Detalle Reserva","Tabla Detalle Solicitud","Tabla Horario","Tabla Reserva","Tabla Solicitante",
            "Tabla Solicitud","Tabla Tarifa","LLenar Base de Datos"};

    String[] activities={"ActividadMenuActivity","AdministradorMenuActivity","AreaMenuActivity","DeporteMenuActivity",
            "DeporteAreaMenuActivity","DetalleReservaMenuActivity","DetalleSolicitudMenuActivity","HorarioMenuActivity",
            "ReservaMenuActivity","SolicitanteMenuActivity","SolicitudMenuActivity","TarifaMenuActivity"};

    ControlBD helper;
    String username;
    String idUser;
    private ArrayList<String> resultados = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new ControlBD(this);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("nomUsuario") ;
        idUser = bundle.getString("idUsuario") ;

        /*try {
            helper = new ControlBD(this);
            Cursor c = helper.obtenerMenuUsuario(idUser);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String desOpcion = c.getString(0);
                        resultados.add(desOpcion);
                    } while (c.moveToNext());
                }
            }
            c.close();
        }catch (SQLiteException e) {
            Log.e(getClass().getSimpleName(), "No se pudo crear o abrir la base de datos");
        }*/

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        /*String nombreValue = "";
        String r = resultados.get(position);

        for(int i=0;i<menu.length;i++){
            if (r.equals(menu[i])){
                nombreValue = activities[i];
                break;
            }
        }

        try {
            Class<?> clase = Class.forName("gr23.fia.ues.sv.admon_poli."+nombreValue);
            Intent inte = new Intent(this,clase);
            inte.putExtra("idUsuario",idUser);
            this.startActivity(inte);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        */
        if(position!=12){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("gr23.fia.ues.sv.admon_poli."+nombreValue);
                Intent inte = new Intent(this,clase);
                inte.putExtra("idUsuario",idUser);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            helper.abrir();
            String tost = helper.llenarBD();
            helper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}