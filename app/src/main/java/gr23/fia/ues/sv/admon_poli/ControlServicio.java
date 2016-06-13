package gr23.fia.ues.sv.admon_poli;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.StreamHandler;

/**
 * Created by FAMILY on 11/06/2016.
 */
public class ControlServicio {

    public static String obtenerRespuestaPeticion(String url, Context ctx) {

        String respuesta = "";

        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);

        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG).show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }

        return respuesta;
    }

    public static List<Solicitud> obtenerSolicitudes(String json, Context ctx) {
        List<Solicitud> listaSolicitud = new ArrayList<Solicitud>();
        try {
            JSONArray solicitudesJSON = new JSONArray(json);
            for (int i = 0; i < solicitudesJSON.length(); i++) {
                Solicitud solicitud = new Solicitud();
                JSONObject obj = solicitudesJSON.getJSONObject(i);
                solicitud.setIdSolicitud(obj.getInt("idsolicitud"));
                solicitud.setFechaReserva(obj.getString("fechareserva"));
                listaSolicitud.add(solicitud);
            }
            return listaSolicitud;
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error en parseo de JSON", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public static int verifiacaActualizar(String respuesta, Context ctx){
        int dato = 0;
        if(respuesta.equalsIgnoreCase("{\"resultado\":1}"))
            dato = 1;
        return dato;
    }

    public static String sumaTarifasJSON(String json, Context ctx) {
        try {
            JSONArray objs = new JSONArray(json);
            if (objs.length() != 0) return objs.getJSONObject(0).getString("total_solicitudes");
            else {
                Toast.makeText(ctx, "Error No hay solicitudes", Toast.LENGTH_LONG).show();
                return " ";
            }
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error con la respuesta JSON", Toast.LENGTH_LONG).show();
            return " ";
        }
    }

    public static List<Tarifa> obtenerTarifaExterno(String json, Context
            ctx) {
        List<Tarifa> listaTarifa = new ArrayList<Tarifa>();
        try {
            JSONArray tarifaJSON = new JSONArray(json);
            for (int i = 0; i < tarifaJSON.length(); i++) {
                JSONObject obj = tarifaJSON.getJSONObject(i);
                Tarifa tarifa = new Tarifa();
                tarifa.setIdTarifa(obj.getInt("idtarifa"));
                tarifa.setPrecio(obj.getDouble("precio"));
                tarifa.setCantPersonas(obj.getInt("cantpersona"));
                tarifa.setCanthora(obj.getDouble("canthora"));
                listaTarifa.add(tarifa);
            }
            return listaTarifa;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseo de JSON", Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }

   /* public static void insertarTarifaPHP(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado",
                        Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/

}

