package gr23.fia.ues.sv.admon_poli;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class ControlBD {

    private static final String[]camposDeporte = new String [] {"iddeporte","nombredeporte"};
    private static final String[]camposDeporteArea = new String [] {"iddeporte","idarea"};
    private static final String[] camposArea = new String [] {"idarea","nombrearea","capacidadarea","area"};
    private static final String[] camposReserva = new String [] {"idreserva","fechareserva","tiemporeserva","idhorario"};
    private static final String[] camposHorario = new String [] {"idhorario","hora","dia","instructor"};
    private static final String[] camposDetalleReserva = new String [] {"idreserva","idarea"};
    private static final String[] camposTarifa = new String [] {"montoarea","canthora","cantpersona"};
    private static final String[] camposSolicitante = new String [] {"dui","apellidosol","telefonosol","emailsol"};
    private static final String[] camposActividad = new String [] {"idactividad","nombreactividad"};
    private static final String[] camposAdministrador = new String [] {"idadministrador","telefonoadmin","emailadmin"};
    private static final String[] camposSolicitud = new String [] {"idsolicitud","estado","fechasolicitud","fechareserva","cantasistentes","idadministrador","idactividad","dui","montoarea"};
    private static final String[] camposDetalleSolicitud = new String [] {"idsolcitud","idarea"};



    private final Context context;     //Almacenara el context de nuestra Activity
    private DatabaseHelper DBHelper; //Nuestro Auxiliador de BD
    private SQLiteDatabase db;      //Instancia de nuestra BD

    public ControlBD(Context ctx) {
        this. context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "AdmonPoli.s3db" ;
        private static final int VERSION = 1;

        DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE deporte(" +
                        "iddeporte INTEGER NOT NULL PRIMARY KEY," +
                        "nombredeporte VARCHAR(30));");
                db.execSQL("CREATE TABLE deportearea(" +
                        "iddeporte INTEGER NOT NULL ," +
                        "idarea INTEGER NOT NULL," +
                        "PRIMARY KEY(iddeporte,idarea));");
                db.execSQL("CREATE TABLE area(" +
                        "idarea INTEGER NOT NULL PRIMARY KEY,\n" +
                        "nombrearea VARCHAR(50)," +
                        "capacidadarea INTEGER," +
                        "area FLOAT);");
                db.execSQL("CREATE TABLE reserva(" +
                        "idreserva INTEGER PRIMARY KEY NOT NULL," +
                        "fechareserva DATE," +
                        "tiemporeserva TIME," +
                        "idhorario INTEGER NOT NULL);");
                db.execSQL("CREATE TABLE horario(" +
                        "idhorario INTEGER NOT NULL PRIMARY KEY," +
                        "hora TIME," +
                        "dia varchar(10)," +
                        "instructor BOOLEAN);");
                db.execSQL("CREATE TABLE detallereserva(" +
                        "idreserva INTEGER NOT NULL," +
                        "idarea INTEGER NOT NULL," +
                        "PRIMARY KEY(idreserva,idarea)" +
                        ");");
                db.execSQL("CREATE TABLE tarifa(" +
                        "montoarea FLOAT PRIMARY KEY NOT NULL," +
                        "canthora TIME," +
                        "cantpersona INTEGER);");
                db.execSQL("CREATE TABLE solicitante(" +
                        "dui INTEGER PRIMARY KEY NOT NULL," +
                        "nombresol VARCHAR(25)," +
                        "apellidosol VARCHAR(25)," +
                        "telefonosol INTEGER," +
                        "emailsol VARCHAR(50));");
                db.execSQL("CREATE TABLE actividad(" +
                        "idactividad INTEGER NOT NULL PRIMARY KEY," +
                        "nombreactividad VARCHAR(50));");
                db.execSQL("CREATE TABLE administrador(" +
                        "idadministrador INTEGER PRIMARY KEY NOT NULL," +
                        "telefonoadmin INTEGER," +
                        "emailadmin VARCHAR(50));");
                db.execSQL("CREATE TABLE solicitud(" +
                        "idsolicitud INTEGER NOT NULL PRIMARY KEY," +
                        "estado VARCHAR(10)," +
                        "fechasolicitud DATE," +
                        "fechareserva DATE," +
                        "cantasistentes INTEGER," +
                        "idadministrador INTEGER NOT NULL," +
                        "idactividad INTEGER NOT NULL," +
                        "dui INTEGER NOT NULL," +
                        "montoarea FLOAT NOT NULL);");
                db.execSQL("CREATE TABLE detallesolicitud (" +
                        "idsolictud INTEGER  NOT NULL," +
                        "idarea INTEGER  NOT NULL," +
                        "PRIMARY KEY (idsolictud,idarea)\n" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase(); //Abrir BD con permisos R/W
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

    //------------------------------------------------------------------------------------
    // metodos CRUD de cada tabla
    public String eliminar(Horario horario){
        return null;
    }

    public String insertar(Horario horario){
        return null;
    }

    public String actualizar(Horario horario){
        return null;
    }

    public Horario consultarHorario(int idHorario){
        return null;
    }

    public String eliminar(Reserva reserva){
        return null;
    }

    public String insertar(Reserva reserva){
        return null;
    }

    public String actualizar(Reserva reserva){
        return null;
    }

    public Reserva consultarReserva(int idReserva){
        return null;
    }

    public String insertar(DetalleReserva detalleReserva){
        return null;
    }

    public String consultar(DetalleReserva detalleReserva){
        return null;
    }

    public String eliminar(DetalleReserva detalleReserva){
        return null;
    }

    public String actualizar(DetalleReserva detalleReserva){
        return null;
    }

    public String actualizar(Tarifa tarifa){
        return null;
    }

    public String consultar(Tarifa tarifa){
        return null;
    }

    public String eliminar(Tarifa tarifa){
        return null;
    }

    public String insertar(Tarifa tarifa){
        return null;
    }

    public String insertar(Solicitante solicitante){
        return null;
    }

    public String consultar(Solicitante solicitante){
        return null;
    }

    public String eliminar(Solicitante solicitante){
        return null;
    }

    public String actualizar(Actividad actividad){
        return null;
    }

    public String consultar(Actividad actividad){
        return null;
    }

    public String eliminar(Actividad actividad){
        return null;
    }

    public String insertar(Actividad actividad){
        return null;
    }

    public String insertar(Administrador administrador){
        return null;
    }

    public String actualizar(Administrador administrador){
        return null;
    }

    public String consultar(Administrador administrador){
        return null;
    }

    public String eliminar(Administrador administrador){
        return null;
    }

    public String insertar(Solicitud solicitud){
        return null;
    }

    public String actualizar(Solicitud solicitud){
        return null;
    }

    public String consultar(Solicitud solicitud){
        return null;
    }

    public String eliminar(Solicitud solicitud){
        return null;
    }

    public String insertar(DetalleSolicitud detalleSolicitud){
        return null;
    }

    public String actualizar(DetalleSolicitud detalleSolicitud){
        return null;
    }

    public String consultar(DetalleSolicitud detalleSolicitud){
        return null;
    }

    public String eliminar(DetalleSolicitud detalleSolicitud){
        return null;
    }






    //------------------------------------------------------------------------
    //Tablas Moisés
    public String eliminar(Area area){return null;}
    public String insertar(Area area){return null;}
    public String actualizar(Area area){return null;}
    public String consultarArea(int idArea){return null;}

    public String eliminar(DeporteArea deporteArea){return null;}
    public String insertar(DeporteArea deporteArea){return null;}
    public String actualizar(DeporteArea deporteArea){return null;}
    public String consultarDeporteArea(int idDeporte,int idArea){return null;}

    public String eliminar(Deporte deporte){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(deporte,17)) {
            contador+=db.delete("deportearea", "iddeporte='"+deporte.getIdDeporte()+"'", null);
        }
        contador+=db.delete("deporte", "iddeporte='"+deporte.getIdDeporte()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    public String insertar(Deporte deporte) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues deport = new ContentValues();
        deport.put("iddeporte", deporte.getIdDeporte());
        deport.put("nombredeporte", deporte.getNombre());
        contador=db.insert("deporte", null, deport);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String actualizar(Deporte deporte){

        if(verificarIntegridad(deporte, 5)){
            String[] id = {String.valueOf(deporte.getIdDeporte())};
            ContentValues cv = new ContentValues();
            cv.put("nombre", deporte.getNombre());
            db.update("deporte", cv, "iddeporte = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con idDeporte " + deporte.getIdDeporte() + " no existe";
        }}
    public Deporte consultarDeporte(int idDeporte){

        String[] id = {String.valueOf(idDeporte)};
        Cursor cursor = db.query("deporte", camposDeporte, "iddeporte = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Deporte deporte = new Deporte();
            deporte.setIdDeporte(cursor.getInt(0));
            deporte.setNombre(cursor.getString(1));
            return deporte;
        }else{ return null;
        }}
    //------------------------------------------------------------------------
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
                //verificar que al insertar deporteArea exista idDeporte del deporte y el idarea de area
                DeporteArea deportearea = (DeporteArea)dato;
                String[] id1 = {String.valueOf(deportearea.getIdDeporte())};
                String[] id2 = {String.valueOf(deportearea.getIdArea())};
                abrir();
                Cursor cursor1 = db.query("deporte", null, "iddeporte = ?", id1, null, null, null);
                Cursor cursor2 = db.query("area", null, "idarea = ?", id2, null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2: {
                //verificar que al insertar detalleReserva exista idarea del area y el idreserva de reservar
                DetalleReserva detalleReserva = (DetalleReserva) dato;
                String[] id1 = {String.valueOf(detalleReserva.getIdReserva())};
                String[] id2 = {String.valueOf(detalleReserva.getIdArea())};
                abrir();
                Cursor cursor1 = db.query("reserva", null, "idreserva = ?", id1, null, null, null);
                Cursor cursor2 = db.query("area", null, "idarea = ?", id2, null, null, null);
                if (cursor1.moveToFirst() && cursor2.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                //verificar que al insertar detallesolicitud exista idarea del area y el idsolicitud de solicitud
                DetalleSolicitud detalleSolicitud = (DetalleSolicitud) dato;
                String[] id1 = {String.valueOf(detalleSolicitud.getIdSolicitud())};
                String[] id2 = {String.valueOf(detalleSolicitud.getIdArea())};
                abrir();
                Cursor cursor1 = db.query("solicitud", null, "idsolicitud = ?", id1, null, null, null);
                Cursor cursor2 = db.query("area", null, "idarea = ?", id2, null, null, null);
                if (cursor1.moveToFirst() && cursor2.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 4:
            {
                //verificar que al insertar solicitud exista MontoArea de la tarifa, el idadministrador de solicitud
                //el idactividad de la actividad, el idsolicitante del solicitante
                Solicitud solicitud = (Solicitud) dato;
                String[] id1 = {String.valueOf(solicitud.getIdAdministrador())};
                String[] id2 = {String.valueOf(solicitud.getIdActividad())};
                String[] id3 = {String.valueOf(solicitud.getMontoArea())};
                String[] id4 = {String.valueOf(solicitud.getDui())};
                abrir();
                Cursor cursor1 = db.query("administrador", null, "idadministrador = ?", id1, null, null, null);
                Cursor cursor2 = db.query("actividad", null, "idactividad = ?", id2, null, null, null);
                Cursor cursor3 = db.query("tarifa", null, "montoarea = ?", id2, null, null, null);
                Cursor cursor4 = db.query("solicitante", null, "dui = ?", id2, null, null, null);
                if (cursor1.moveToFirst() && cursor2.moveToFirst() && cursor3.moveToFirst() && cursor4.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 5:
            {
                //verificar que exista deporte
                Deporte deporte = (Deporte)dato;
                String[] id = {String.valueOf(deporte.getIdDeporte())};
                abrir();
                Cursor cursor = db.query("deporte", null, "iddeporte = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 6:
            {
                //verificar que exista deportearea
                DeporteArea deporteArea = (DeporteArea)dato;
                String[] ids = {String.valueOf(deporteArea.getIdDeporte()), String.valueOf(deporteArea.getIdArea())};
                abrir();
                Cursor cursor = db.query("deportearea", null, "iddeporte = ? AND idarea = ?", ids, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 7:
            {
                //verificar que exista area
                Area area = (Area)dato;
                String[] id = {String.valueOf(area.getIdArea())};
                abrir();
                Cursor cursor = db.query("area", null, "idarea = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 8:
            {
                //verificar que exista deportearea
                DetalleReserva detalleReserva = (DetalleReserva)dato;
                String[] ids = {String.valueOf(detalleReserva.getIdArea() ), String.valueOf(detalleReserva.getIdReserva())};
                abrir();
                Cursor cursor = db.query("detallereserva", null, "idarea = ? AND idreserva = ?", ids, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 9:{
                //verificar que exista deportearea
                Reserva reserva = (Reserva)dato;
                String[] id = {String.valueOf(reserva.getIdReserva())};
                abrir();
                Cursor cursor = db.query("reserva", null, "idreserva = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 10:
            {
                //verificar que exista deportearea
                Horario horario = (Horario)dato;
                String[] id = {String.valueOf(horario.getIdHorario())};
                abrir();
                Cursor cursor = db.query("horario", null, "idhorario = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 11:
            {
                //verificar que exista deportearea
                DetalleSolicitud detalleSolicitud = (DetalleSolicitud)dato;
                String[] ids = {String.valueOf(detalleSolicitud.getIdArea() ), String.valueOf(detalleSolicitud.getIdSolicitud())};
                abrir();
                Cursor cursor = db.query("detallesolicitud", null, "idarea = ? AND idsolicitud = ?", ids, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 12:
            {
                //verificar que exista deportearea
                Solicitud solicitud = (Solicitud)dato;
                String[] id = {String.valueOf(solicitud.getIdSolicitud())};
                abrir();
                Cursor cursor = db.query("solicitud", null, "idsolicitud = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 13:
            {
                //verificar que exista Actividad
                Actividad actividad = (Actividad)dato;
                String[] id = {String.valueOf(actividad.getIdActividad())};
                abrir();
                Cursor cursor = db.query("actividad", null, "idactividad = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 14:
            {
                //verificar que exista administrador
                Administrador administrador = (Administrador)dato;
                String[] id = {String.valueOf(administrador.getIdAdministrador())};
                abrir();
                Cursor cursor = db.query("administrador", null, "idadministrador = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 15:
            {
                //verificar que exista deportearea
                Solicitante solicitante = (Solicitante)dato;
                String[] id = {String.valueOf(solicitante.getDui())};
                abrir();
                Cursor cursor = db.query("solicitante", null, "dui = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 16:
            {
                //verificar que exista deportearea
                Actividad actividad = (Actividad)dato;
                String[] id = {String.valueOf(actividad.getIdActividad())};
                abrir();
                Cursor cursor = db.query("actividad", null, "idactividad = ?", id, null, null, null);
                if(cursor.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 17:
            {
                //verificar que al eliminar deporte no exista en deporte area
                Deporte deporte = (Deporte) dato;
                String[] id1 = {String.valueOf(deporte.getIdDeporte())};
                abrir();
                Cursor cursor1 = db.query("deportearea", null, "iddeporte = ?", id1, null, null, null);
                if (cursor1.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            default:
                return false;
        }



}
    public String llenarBD(){
        final int[] VDiddeporte = {1,2,3,4};
        final String[] VDnombredeporte = {"Natación","Futbol","Basketball","Voleyball"};

        final int[] VDAiddeporte = {1,2,3,4};
        final int[] VDAidarea = {1,2,3,4};

        final int[] VAidarea = {1,2,3,4};
        final String[] VAnombrearea = {"Picsina","Cancha 11","Cancha Papi","Duela"};
        final int[] VAcapacidadarea = {110,5000,100,1000};
        final float[] VAarea = {1875,22500,600,1200};

        final int[] VDRidarea = {1,2,3,4};
        final int[] VDRidreserva = {1,2,3,4};

        final int[] VRidreserva = {1,2,3,4};
        final int[] VRidhorario = {1,2,3,4};
        final String[] VRfechareserva = {"10/05/16","10/05/16","10/05/16","10/05/16"};
        final String[] VRtiemporeserva = {"10.05.16","10.05.16","10.05.16","10.05.16"};

        final int [] VHidhorario = {1,2,3,4};
        final String[] VHhora = {"10.05.16","10.05.16","10.05.16","10.05.16"};
        final String[] VHdia = {"Lunes","Martes","Miercoles","Jueves"};
        final boolean[] VHinstructor = {true,false,true,false};


        final double[] VTmontoarea = {56.89,32.4,123.5,789.3};
        final double[] VTcanthora = {1.3,5.6,9.3,7.8};
        final int[] VTcantpersona = {100,200,500,500};


        final String[] VSdui = {"12897856234","78894556231","7889455628","78894556235"};
        final String[] VSnombresol = {"Moisés","Alberto","Pablo","Samuel"};
        final String[] VSapellidosol = {"Herrera","Sanchez","Tobar","Jovel"};
        final int[] VStelefonosol = {78895612,73235689,71235689,79455612};
        final String[] VSemailsol = {"moises.oct@gmail.com","sanchez@gmail.com","tobar@gmail.com","jovel@gmail.com"};

        final int[] VAidactividad = {1,2,3,4};
        final String[] VAnombreactividad = {"Politica","Cultural","Religiosa","Politica"};

        final int[] VADidadministrador = {1,2,3,4};
        final int[] VADtelefonoadmin = {78894556,65231245,78895612,75231256};
        final String[] VADemailadmin = {"moises.oct@gmail.com","sanchez@gmail.com","tobar@gmail.com","jovel@gmail.com"};

        final int[] VSOidsolicitud = {1,2,3,4};
        final String[] VSOestado = {"Aprobado","Denegado","En proceso","Aprobado"};
        final String[] VSOfechasolictud = {"06/02/16","06/02/16","06/02/16","06/02/16"};
        final String[] VSOfechareserva = {"06/02/16","06/02/16","06/02/16","06/02/16"};
        final int[] VSOcantasistentes = {100,200,500,300};
        final int[] VSOidadministrador = {1,2,3,4};
        final int[] VSOidactividad = {1,2,3,4};

        final String[] VSOdui = {"12897856234","78894556231","7889455628","78894556235"};

        final double[] VSOmontoarea = {56.89,32.4,123.5,789.3};

        final int[] VDSidsolicitud = {1,2,3,4};
        final int[] VDSidarea = {1,2,3,4};

        abrir();
        db.execSQL("DELETE FROM deporte");
        db.execSQL("DELETE FROM deportearea");
        db.execSQL("DELETE FROM area");
        db.execSQL("DELETE FROM detallereserva");
        db.execSQL("DELETE FROM tarifa");
        db.execSQL("DELETE FROM solicitante");
        db.execSQL("DELETE FROM reserva");
        db.execSQL("DELETE FROM actividad");
        db.execSQL("DELETE FROM horario");
        db.execSQL("DELETE FROM administrador");
        db.execSQL("DELETE FROM solicitud");
        db.execSQL("DELETE FROM detallesolicitud");

        Deporte deporte = new Deporte();
        for(int i=0;i<4;i++){
            deporte.setIdDeporte(VDiddeporte[i]);
            deporte.setNombre(VDnombredeporte[i]);
            insertar(deporte);
        }
        DeporteArea deportearea = new DeporteArea();
        for(int i=0;i<4;i++){
            deportearea.setIdArea(VDAidarea[i]);
            deportearea.setIdDeporte(VDAiddeporte[i]);
            insertar(deportearea);
        }
        Area area = new Area();
        for(int i=0;i<4;i++){
            area.setIdArea(VAidarea[i]);
            area.setNombre(VAnombrearea[i]);
            area.setCapacidad(VAcapacidadarea[i]);
            area.setArea(VAarea[i]);
            insertar(area);
        }
        Reserva reserva = new Reserva();
        for(int i=0;i<4;i++){
            reserva.setIdReserva(VRidreserva[i]);
            reserva.setFechaReserva(VRfechareserva[i]);
            reserva.setTiempoReserva(VRtiemporeserva[i]);
            reserva.setIdHorario(VRidhorario[i]);
            insertar(reserva);
        }

        Horario horario = new Horario();
        for(int i=0;i<4;i++){
            horario.setIdHorario(VHidhorario[i]);
            horario.setHora(VHhora[i]);
            horario.setDia(VHdia[i]);
            horario.setInstructor(VHinstructor[i]);
            insertar(horario);
        }
        DetalleReserva detallereserva = new DetalleReserva();
        for(int i=0;i<4;i++){
            detallereserva.setIdReserva(VDRidreserva[i]);
            detallereserva.setIdArea(VDRidarea[i]);

            insertar(detallereserva);
        }

        Tarifa tarifa = new Tarifa();
        for(int i=0;i<4;i++){
            tarifa.setMontoArea(VTmontoarea[i]);
            tarifa.setCanthora(VTcanthora[i]);
            tarifa.setCantPersonas(VTcantpersona[i]);
            insertar(tarifa);
        }

        Solicitante solicitante = new Solicitante();
        for(int i=0;i<4;i++){
            solicitante.setDui(VSdui[i]);
            solicitante.setNombreSol(VSnombresol[i]);
            solicitante.setApellidoSol(VSapellidosol[i]);
            solicitante.setTelefonoSol(VStelefonosol[i]);
            solicitante.setMail(VSemailsol[i]);
            insertar(solicitante);
        }

        Actividad actividad = new Actividad();
        for(int i=0;i<4;i++) {
            actividad.setIdActividad(VAidactividad[i]);
            actividad.setNombreactividad(VAnombreactividad[i]);
            insertar(actividad);
        }

        Administrador administrador = new Administrador();
        for(int i=0;i<4;i++) {
            administrador.setIdAdministrador(VADidadministrador[i]);
            administrador.setTelefonoadmin(VADtelefonoadmin[i]);
            administrador.setEmailadmin(VADemailadmin[i]);
            insertar(administrador);
        }

        Solicitud solicitud = new Solicitud();
        for(int i=0;i<4;i++) {
            solicitud.setIdSolicitud(VSOidsolicitud[i]);
            solicitud.setEstado(VSOestado[i]);
            solicitud.setFechaSolicitud(VSOfechasolictud[i]);
            solicitud.setFechaReserva(VSOfechareserva[i]);
            solicitud.setCantAsistentes(VSOcantasistentes[i]);
            solicitud.setIdAdministrador(VSOidadministrador[i]);
            solicitud.setIdActividad(VSOidactividad[i]);
            solicitud.setDui(VSOdui[i]);
            solicitud.setMontoArea(VSOmontoarea[i]);
            insertar(solicitud);
        }

        DetalleSolicitud detalleSolicitud = new DetalleSolicitud();
        for(int i=0;i<4;i++) {
            detalleSolicitud.setIdSolicitud(VDSidsolicitud[i]);
            detalleSolicitud.setIdArea(VDSidarea[i]);
            insertar(detalleSolicitud);
        }
        cerrar();
        return "Guardo Correctamente";
    }
}



