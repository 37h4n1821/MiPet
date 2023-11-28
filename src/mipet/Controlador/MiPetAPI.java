/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Controlador;

/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */


import mipet.Modelo.Cliente;
import mipet.Modelo.Tipo_Mascota;
import mipet.Modelo.Mascota;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */
public class MiPetAPI {
    private String servidor;
    private String rutaAPI;

    public MiPetAPI(String servidor, String rutaAPI) {
        this.servidor = servidor;
        this.rutaAPI = rutaAPI;
    }
    
    
    public boolean enviar(Mascota mascota) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(mascota);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();
        
        if (responseCode==200){
            return true;
        }
        return false;
        
    }
    
    
    public boolean enviar(Cliente mascota) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(mascota);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();
        
        if (responseCode==200){
            return true;
        }
        return false;
        
    }
    
    
    public boolean enviar(Tipo_Mascota mascota) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(mascota);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();
        
        if (responseCode==200){
            return true;
        }
        return false;
        
    }
    
    
    public ArrayList<Mascota> ObtenerMascotas() throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                
                String jsonResponse = response.toString();
                
                Gson gson = new Gson();

                ArrayList<Mascota> sbrec = gson.fromJson(jsonResponse, new TypeToken<ArrayList<Mascota>>(){}.getType());
                
                return sbrec;
            }
        } else {
            return null;
        }
        
    }
    
    
    public ArrayList<Tipo_Mascota> ObtenerTipos() throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                
                String jsonResponse = response.toString();
                
                Gson gson = new Gson();

                ArrayList<Tipo_Mascota> sbrec = gson.fromJson(jsonResponse, new TypeToken<ArrayList<Tipo_Mascota>>(){}.getType());
                
                return sbrec;
            }
        } else {
            return null;
        }
        
    }
    
    public ArrayList<Cliente> ObtenerClientes() throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                
                String jsonResponse = response.toString();
                
                Gson gson = new Gson();

                ArrayList<Cliente> sbrec = gson.fromJson(jsonResponse, new TypeToken<ArrayList<Cliente>>(){}.getType());
                
                return sbrec;
            }
        } else {
            return null;
        }
        
    }
    
    public int CantidadMascotas(Cliente cliente) throws IOException{
        URL url = new URL(servidor + rutaAPI+"/cant/"+cliente.get_id());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "text/plain");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                
                String jsonResponse = response.toString();
                
                return Integer.parseInt(jsonResponse);
            }
        }
        
        return 0;
    }
    
    public boolean actualizar(Mascota sb) throws IOException {
        
        URL url = new URL(servidor + rutaAPI+"/upd/"+sb.get_id());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            Gson gson2 = new Gson();
            String objetoJSON = gson.toJson(sb);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();
        
        return responseCode==200;
        
    }
    
    
    public boolean eliminar(Mascota sb) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(sb);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();

        return (responseCode == HttpURLConnection.HTTP_OK);
        
    }
    
    public boolean eliminar(Cliente sb) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(sb);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();

        return (responseCode == HttpURLConnection.HTTP_OK);
        
    }
    
    public boolean eliminar(Tipo_Mascota sb) throws IOException {
        
        URL url = new URL(servidor + rutaAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            
            Gson gson = new Gson();
            String objetoJSON = gson.toJson(sb);
            System.out.println(objetoJSON);
            writer.write(objetoJSON);
        }

        int responseCode = connection.getResponseCode();

        return (responseCode == HttpURLConnection.HTTP_OK);
        
    }
    
    
    
}
