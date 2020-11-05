/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Episodio;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author bvegam
 */
public class ServerImplements extends UnicastRemoteObject implements RMI{
    

    public ServerImplements() throws RemoteException {
        super();
    }

    @Override
    public String obtenerEpisodio(int id) throws RemoteException {
        try {
            CloseableHttpClient cliente = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://rickandmortyapi.com/api/episode/"+id);
            CloseableHttpResponse response = cliente.execute(request);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    Gson g = new Gson();  
                    Episodio episodio = g.fromJson(result, Episodio.class);
                    response.close();
                    cliente.close();
                    return "El episodio es: "+ episodio.getName();
                }else{
                    response.close();
                    cliente.close();
                    return "No existe ese episodio";
                }
            }else{
                response.close();
                cliente.close();
                return "Error al obtener episodio";
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }
    
}
