package gr23.fia.ues.sv.admon_poli;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class ControlBD {

    private static final String[]camposDeporte = new String [] {"iddeporte","nombredeporte"};
    private static final String[]camposDeporteArea = new String [] {"iddeporte","idarea","descripcion","activo"};
    private static final String[] camposArea = new String [] {"idarea","nombrearea","capacidadarea","area"};
    private static final String[] camposReserva = new String [] {"idreserva","fechareserva","tiemporeserva","idhorario"};
    private static final String[] camposHorario = new String [] {"idhorario","hora","dia","instructor"};
    private static final String[] camposDetalleReserva = new String [] {"idreserva","idarea"};
    private static final String[] camposTarifa = new String [] {"montoarea","canthora","cantpersona"};
    private static final String[] camposSolicitante = new String [] {"dui","apellidosol","telefonosol","emailsol"};
    private static final String[] camposActividad = new String [] {"idactividad","nombreactividad"};
    private static final String[] camposAdministrador = new String [] {"idadministrador","telefonoadmin","emailadmin"};
    private static final String[] camposSolicitud = new String [] {"idsolicitud","estado","fechasolicitud","fechareserva","cantasistentes","idadministrador","idactividad","dui","montoarea", "horareserva"};
    private static final String[] camposDetalleSolicitud = new String [] {"idsolicitud","idarea"};



    private final Context context;     //Almacenara el context de nuestra Activity
    private DatabaseHelper DBHelper; //Nuestro Auxiliador de BD
    private SQLiteDatabase db;      //Instancia de nuestra BD

    public ControlBD(Context ctx) {
        this. context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "AdmonPoliv6.s3db" ;
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
                        "iddeporte INTEGER NOT NULL," +
                        "idarea INTEGER NOT NULL," +
                        "descripcion VARCHAR(100)," +
                        "activo VARCHAR(25)," +
                        "PRIMARY KEY(iddeporte,idarea));");
                db.execSQL("CREATE TABLE area(" +
                        "idarea INTEGER NOT NULL PRIMARY KEY," +
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
                        "dui VARCHAR(9) PRIMARY KEY NOT NULL," +
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
                        "dui VARCHAR(9) NOT NULL," +
                        "montoarea FLOAT NOT NULL," +
                        "horareserva TIME NOT NULL);");
                db.execSQL("CREATE TABLE detallesolicitud (" +
                        "idsolicitud INTEGER  NOT NULL," +
                        "idarea INTEGER  NOT NULL," +
                        "PRIMARY KEY (idsolicitud,idarea)" +
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

   /* public Administrador consultar(int idAdministrador){
        return null;
    }

    public String eliminar(Administrador administrador){
        return null;
    }

    public String insertar(Administrador administrador){
        return null;
    }

    public String actualizar(Administrador administrador){
        return null;
    }*/

    public String actualizar(Solicitante solicitante){
        return null;
    }

    public Solicitante consultarSolicitante(int idSolicitante){
        return null;
    }

    public String eliminar(Solicitante solicitante){
        return null;
    }

    public String insertar(Solicitante solicitante){
        return null;
    }
//////////////////////ACTIVIDAD //////////////////////////////////////////////////////////////////////
    public Actividad consultarActividad(int idactividad){
        String[] id = {String.valueOf(idactividad)};
        Cursor cursor = db.query("actividad" , camposActividad, "idactividad = ?" , id,
                null, null, null);
        if(cursor.moveToFirst()){
            Actividad actividad = new Actividad() ;
            actividad.setIdActividad(cursor.getInt(0));
            actividad.setNombre(cursor.getString(1));
            return actividad;
        }else{
            return null;
        }
    }

    public String actualizar (Actividad actividad){
        if(verificarIntegridad(actividad, 13)){

            String[] id = {String.valueOf(actividad.getIdActividad())};
            ContentValues cv = new ContentValues();
            cv.put("nombreactividad",actividad.getNombre() );
            db.update("actividad", cv, "idactividad = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro de la actividad " +actividad.getIdActividad()  + " no existe";
        }
    }

    public String eliminar(Actividad actividad){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(actividad,13)) {
            contador+=db.delete("solicitud", "idactividad='"+actividad.getIdActividad()+"'", null);
        }
        contador+=db.delete("actividad", "idactividad='"+actividad.getIdActividad()+"'", null);
        regAfectados+=contador;
        return regAfectados;


    }

    public String insertar(Actividad actividad) {

        String regInsertados="Registro Insertado Nº= ";
        long contador = 0;
        ContentValues act = new ContentValues();
        act.put("idactividad", actividad.getIdActividad());
        act.put("nombreactividad", actividad.getNombre());
        contador = db.insert("actividad", null, act);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados = regInsertados+contador;
        }
        return regInsertados;
    }
///////////////////////////////ADMINISTRADOR ///////////////////////////////////////////////
public String insertar(Administrador administrador) {
    String regInsertados="Registro Insertado Nº= ";
    long contador=0;
    ContentValues admin = new ContentValues();
    admin.put("idadministrador", administrador.getIdAdministrador());
    admin.put("telefonoadmin", administrador.getTelefonoadmin());
    admin.put("emailadmin",administrador.getEmailadmin());
    contador=db.insert("administrador", null, admin);
    if(contador==-1 || contador==0)
    {
        regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
    }
    else {
        regInsertados=regInsertados+contador;
    }
    return regInsertados;
}


    public String actualizar(Administrador administrador){
        if(verificarIntegridad(administrador, 14)){
            String[] id = {String.valueOf(administrador.getIdAdministrador())};
            ContentValues cv = new ContentValues();
            cv.put("telefonoadmin", administrador.getTelefonoadmin());
            cv.put("emailadmin", administrador.getEmailadmin());
            db.update("admininistrador", cv, "idadministrador = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con credenciales de administrador " + administrador.getIdAdministrador() + " no existe";
        }
    }

    public Administrador consultar(int idadministrador){
        String[] id = {String.valueOf(idadministrador)};
        Cursor cursor = db.query("administrador", camposAdministrador, "idadministrador = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Administrador administrador = new Administrador();
            administrador.setIdAdministrador(cursor.getInt(0));
            administrador.setTelefonoadmin(Integer.parseInt(cursor.getString(1)));
            return administrador;
        }else{ return null;
        }
    }

    public String eliminar(Administrador administrador){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="idadministrador='"+administrador.getIdAdministrador()+"'";
        contador+=db.delete("administrador", where, null);
        regAfectados+=contador;
        return regAfectados;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Tablas Alberto
    public String insertar(Solicitud solicitud){
        String regInsertados="Registro Insertado Nº= ";
        long contador = 0;
        ContentValues solt = new ContentValues();
        solt.put("idsolicitud", solicitud.getIdSolicitud()); // la genera el activity
        solt.put("estado", solicitud.getEstado());
        solt.put("fechasolicitud", solicitud.getFechaSolicitud());//la genera el activity
        solt.put("fechareserva", solicitud.getFechaReserva());
        solt.put("cantasistentes", solicitud.getCantAsistentes());
        solt.put("idadministrador", solicitud.getIdAdministrador());
        solt.put("idactividad", solicitud.getIdActividad());
        solt.put("dui", solicitud.getDui()); //la recupera el activity
        solt.put("montoarea", solicitud.getMontoArea());
        solt.put("horareserva", solicitud.getHoraReservada());
        contador = db.insert("solicitud", null, solt);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados = regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(Solicitud solicitud){

        if(verificarIntegridad(solicitud, 12)){
            String[] id = {String.valueOf(solicitud.getIdSolicitud())};
            ContentValues cv = new ContentValues();
            cv.put("estado", solicitud.getEstado()); // solo lo modifica el admin
            cv.put("montoarea",solicitud.getMontoArea());
            cv.put("fechareserva",solicitud.getFechaReserva());
            cv.put("fechasolicitud",solicitud.getFechaSolicitud());
            cv.put("cantasistentes",solicitud.getCantAsistentes());
            cv.put("idactividad",solicitud.getIdActividad());
            cv.put("idadministrador",solicitud.getIdAdministrador());
            cv.put("dui",solicitud.getDui());
            cv.put("horareserva",solicitud.getHoraReservada());
            db.update("solicitud", cv, "idsolicitud = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con idSolicitud " + solicitud.getIdSolicitud() + " no existe";
        }
    }

    public Solicitud consultarSolicitud(int idsolicitud){

        String[] id = {String.valueOf(idsolicitud)};
        Cursor cursor = db.query("solicitud", camposSolicitud, "idsolicitud = ?" , id, null, null, null);
        if(cursor.moveToFirst()){
            Solicitud solicitud = new Solicitud() ;
            solicitud.setIdSolicitud(cursor.getInt(0));
            solicitud.setEstado(cursor.getString(1));
            solicitud.setFechaReserva(cursor.getString(2));
            solicitud.setFechaSolicitud(cursor.getString(3));
            solicitud.setCantAsistentes(cursor.getInt(4));
            solicitud.setIdAdministrador(cursor.getInt(5));
            solicitud.setIdActividad(cursor.getInt(6));
            solicitud.setDui(cursor.getString(7));
            solicitud.setMontoArea(cursor.getDouble(8));
            solicitud.setHoraReservada(cursor.getString(9));
            return solicitud;
        }else{
            return null;
        }
    }

    public String eliminar(Solicitud solicitud){

        String regAfectados="Filas afectadas= ";
        int contador = 0;
        /*if (verificarIntegridad(solicitud,18)) {
            contador+=db.delete("detallesolicitud", "idsolicitud='"+solicitud.getIdSolicitud()+"'", null);
        }*/
        contador+=db.delete("solicitud", "idsolicitud='"+solicitud.getIdSolicitud()+"'", null);
        regAfectados+=contador;
        return regAfectados;

    }

    public String insertar(DetalleSolicitud detalleSolicitud){
        String regInsertados="Registro Insertado Nº= ";
        long contador = 0;
        ContentValues dsolt = new ContentValues();
        dsolt.put("idarea", detalleSolicitud.getIdArea());
        dsolt.put("idsolicitud", detalleSolicitud.getIdSolicitud());
        contador = db.insert("detallesolicitud", null, dsolt);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados = regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(DetalleSolicitud detalleSolicitud){
        if(verificarIntegridad(detalleSolicitud, 3)){
            String[] ids = {String.valueOf(detalleSolicitud.getIdSolicitud()), String.valueOf(detalleSolicitud.getIdArea())};
            ContentValues cv = new ContentValues();
            db.update("detallesolicitud", cv, "idsolicitud = ? AND idarea = ?", ids);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con idSolicitud " + detalleSolicitud.getIdSolicitud() + " y idarea"+ detalleSolicitud.getIdArea()  +" no existe";
        }
    }

    public DetalleSolicitud consultarDS(int idSolicitud, int idarea){
        String[] ids = {String.valueOf(idSolicitud), String.valueOf(idarea)};
        Cursor cursor = db.query("detallesolicitud", camposDetalleSolicitud, "idsolicitud = ? AND idarea = ?" , ids, null, null, null);
        if(cursor.moveToFirst()){
            DetalleSolicitud detsolicitud = new DetalleSolicitud() ;
            detsolicitud.setIdSolicitud(cursor.getInt(0));
            detsolicitud.setIdArea(cursor.getInt(1));
            return detsolicitud;
        }else{
            return null;
        }
    }

    public String eliminar(DetalleSolicitud detalleSolicitud){
        String regAfectados="Filas afectadas= ";
        int contador = 0;
        if (verificarIntegridad(detalleSolicitud,3)) {
            contador+=db.delete("detallesolicitud", "idsolicitud='"+ detalleSolicitud.getIdSolicitud() +"'", null);
        }
        regAfectados+=contador;
        return regAfectados;
    }

    public int count(String tabla){
        int c = 0 ;
        Cursor cursor = db.rawQuery("Select count(*) from " + tabla, null) ;
        if(cursor.moveToFirst()){
            c = cursor.getInt(0) ;
        }
        return c ;
    }




    //-----------------------------------------------------------------------------------------------
    //Tablas Moisés
    public String eliminar(Area area){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(area,19)) {
            contador+=db.delete("deportearea", "idarea='"+area.getIdArea()+"'", null);
        }
        contador+=db.delete("area", "idarea='"+area.getIdArea()+"'", null);
        regAfectados+=contador;
        return regAfectados;}

    public String insertar(Area area){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues ar = new ContentValues();
        ar.put("idarea",area.getIdArea());
        ar.put("nombrearea", area.getNombre());
        ar.put("capacidadarea", area.getCapacidad());
        ar.put("area",area.getArea());
        contador=db.insert("area", null, ar);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;}

    public String actualizar(Area area){
        if(verificarIntegridad(area, 7)){
            String[] id = {String.valueOf(area.getIdArea())};
            ContentValues cv = new ContentValues();
            cv.put("nombrearea", area.getNombre());
            cv.put("capacidadarea", area.getCapacidad());
            cv.put("area", area.getArea());
            db.update("area", cv, "idarea = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con idArea " + area.getIdArea() + " no existe";
        }}

    public Area consultarArea(int idArea){
        String[] id = {String.valueOf(idArea)};
        Cursor cursor = db.query("area", camposArea, "idarea = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Area area = new Area();
            area.setIdArea(cursor.getInt(0));
            area.setNombre(cursor.getString(1));
            area.setCapacidad(cursor.getInt(2));
            area.setArea(cursor.getFloat(3));
            return area;
        }else{ return null;
        }}

    public String eliminar(DeporteArea deporteArea){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="iddeporte='"+deporteArea.getIdDeporte()+"'";
        where=where+" AND idarea='"+deporteArea.getIdArea()+"'";
        contador+=db.delete("deportearea", where, null);
        regAfectados+=contador;
        return regAfectados;}
//Insertar deportearea deben existir deporte y area antes
    public String insertar(DeporteArea deporteArea){

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        if(verificarIntegridad(deporteArea,1)){
        ContentValues deportarea = new ContentValues();
        deportarea.put("iddeporte", deporteArea.getIdDeporte());
        deportarea.put("idarea", deporteArea.getIdArea());
        deportarea.put("descripcion", deporteArea.getDescripcion());
        deportarea.put("activo", deporteArea.isActivo());
        contador=db.insert("deportearea", null, deportarea);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }}else{
             regInsertados="No existen relaciones Area y Deporte ";
        }
        return regInsertados;}

    public String actualizar(DeporteArea deporteArea){
        if(verificarIntegridad(deporteArea, 6)){
            String[] id = {String.valueOf(deporteArea.getIdDeporte()), String.valueOf(deporteArea.getIdArea())};
            ContentValues cv = new ContentValues();
            cv.put("descripcion", deporteArea.getDescripcion());
            cv.put("activo", deporteArea.isActivo());
            db.update("deportearea", cv, "iddeporte = ? AND idarea = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }}

    public DeporteArea consultarDeporteArea(int idDeporte,int idArea){

        String[] id = {String.valueOf(idDeporte), String.valueOf(idArea)};
        Cursor cursor = db.query("deportearea", camposDeporteArea, "iddeporte = ? AND idarea = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            DeporteArea da = new DeporteArea();
            da.setIdArea(cursor.getInt(0));
            da.setIdDeporte(cursor.getInt(1));
            da.setDescripcion(cursor.getString(2));
            da.setActivo(cursor.getString(3));
            return da;
        }else{
            return null;
        }}

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
            cv.put("nombredeporte", deporte.getNombre());
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
    //------------------------------------------------------------------------------------------------
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
                Solicitud solicitud = (Solicitud) dato;
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
            case 18:
            {
                //verificar que al eliminar solicitud no exista en detallesolicitud
                Solicitud solicitud = (Solicitud) dato;
                String[] id1 = {String.valueOf(solicitud.getIdSolicitud())};
                abrir();
                Cursor cursor1 = db.query("detallesolicitud", null, "idsolicitud = ?", id1, null, null, null);
                if (cursor1.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 19:
            {
                //verificar que al area no exista en deporteArea
                Area area = (Area) dato;
                String[] id1 = {String.valueOf(area.getIdArea())};
                abrir();
                Cursor cursor1 = db.query("deportearea", null, "idarea = ?", id1, null, null, null);
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

        final int[] VAidarea = {1,2,3,4};
        final String[] VAnombrearea = {"Picsina","Cancha 11","Cancha Papi","Duela"};
        final int[] VAcapacidadarea = {110,5000,100,1000};
        final float[] VAarea = {1875,22500,600,1200};

        final int[] VDAiddeporte = {1,2,3,4};
        final int[] VDAidarea = {1,2,3,4};
        final String[] VDAdescripcion={"Natación en Picsina","Futbol cancha reglamental","Basketball cancha Papi","Voleyball en Duela"};
        final String[] VDAactivo={"activo","activo","inactivo","activo"};

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
        final String[] VSOhoraReserva = {"10.30.00", "12.00.00", "2.00.00", "4.30.00"};

        final String[] VSOdui = {"12897856234","78894556231","7889455628","78894556235"};

        final double[] VSOmontoarea = {56.89,32.4,123.5,789.3};

        final int[] VDSidsolicitud = {1,2,3,4};
        final int[] VDSidarea = {1,2,3,4};

        abrir();
        db.execSQL("DELETE FROM deporte");
        db.execSQL("DELETE FROM area");
        db.execSQL("DELETE FROM deportearea");
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

        Area area = new Area();
        for(int i=0;i<4;i++){
            area.setIdArea(VAidarea[i]);
            area.setNombre(VAnombrearea[i]);
            area.setCapacidad(VAcapacidadarea[i]);
            area.setArea(VAarea[i]);
            insertar(area);
        }
        DeporteArea deportearea = new DeporteArea();
        for(int i=0;i<4;i++){
            deportearea.setIdArea(VDAidarea[i]);
            deportearea.setIdDeporte(VDAiddeporte[i]);
            deportearea.setDescripcion(VDAdescripcion[i]);
            deportearea.setActivo(VDAactivo[i]);
            insertar(deportearea);
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
            actividad.setNombre(VAnombreactividad[i]);
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
            solicitud.setHoraReservada(VSOhoraReserva[i]);
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
    //by Moisés Herrera!!!
    public int contarRegistros(String tabla,String id) {
        String[] campos = new String[]{id};
        abrir();
        int contador=0;
        Cursor c = db.query(tabla, campos, null, null, null, null,null);
        if (c.moveToFirst()) {
            do {
                contador++;
            } while (c.moveToNext());
        }
        return contador;
    }

    public List consultaArea(){
        abrir();
        List<String> lista= new ArrayList<>();
        Cursor cur=db.rawQuery("select idarea,nombrearea from area",null );
        while(cur.moveToNext()){
            lista.add(cur.getString(0)+"-"+cur.getString(1));
        }
        cur.close();
        db.close();
        return(lista);
    }
    public List consultaDeporte(){
        abrir();
        List<String> lista= new ArrayList<>();
        Cursor cur=db.rawQuery("select iddeporte,nombredeporte from deporte",null );
        while(cur.moveToNext()){
            lista.add(cur.getString(0)+"-"+cur.getString(1));
        }
        cur.close();
        db.close();
        return(lista);
    }

}



