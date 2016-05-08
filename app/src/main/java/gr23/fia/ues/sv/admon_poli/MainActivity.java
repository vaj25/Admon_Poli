package gr23.fia.ues.sv.admon_poli;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends ListActivity {
    String[] menu={"Tabla Actividad","Tabla Administrador","Tabla Area","Tabla Deporte","Tabla DeporteArea",
            "Tabla Detalle Reserva","Tabla Detalle Solicitud","Tabla Horario","Tabla Reserva","Tabla Solicitante",
            "Tabla Solicitud","Tabla Tarifa","LLenar Base de Datos"};

    String[] activities={"ActividadMenuActivity","AdministradorMenuActivity","AreaMenuActivity","DeporteMenuActivity",
            "DeporteAreaMenuActivity","DetalleReservaMenuActivity","DetalleSolicitudMenuActivity","HorarioMenuActivity",
            "ReservaMenuActivity","SolicitanteMenuActivity","SolicitudMenuActivity","TarifaMenuActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=12){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("gr23.fia.ues.sv.admon_poli."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            //CODIGO PARA LLENAR BASE DE DATOS
        }
    }
}