package com.SecurVision.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.userInterface.Frameworks;

import javafx.scene.control.Alert.AlertType;

public class PersonaDAOImp implements IPersonaDAO {
	
	Frameworks frame=new Frameworks();

	/**
	 ** LISTAR PERSONAS **
	 **/
	@Override
	public List<PersonaDTO> listarPersonas(){
	//public static void main(String[]args){
		List<PersonaDTO> list_users = new ArrayList<>();
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			HttpGet getRequest = new HttpGet(Constants.PERSONA_URL);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);

			int code = response.getStatusLine().getStatusCode();

			// Check for HTTP response code: 200 = success
			if (code != 200) {
				frame.Alert(AlertType.ERROR, "Servidor No operativo", "Operaci�n no permitida "
		    			+ "HTTP Error "+ code);
				//throw new DAOExcepcion("Failed : HTTP error code : " + code + response.getStatusLine());
			}

			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			System.out.println(body);

			JSONArray jsonArray = new JSONArray(body);

			for (int i = 0; i < jsonArray.length(); i++) {
			    JSONObject jsonobject = jsonArray.getJSONObject(i);
			    String name = jsonobject.getString("nombre");
			    String surname = jsonobject.getString("apellidos");
			    String dni = jsonobject.getString("dni");

			    PersonaDTO p = new PersonaDTO(dni, name, surname);
			    list_users.add(p);
			}

			CloseableHttpResponse response1 = (CloseableHttpResponse) httpClient.execute(getRequest);
			response1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

      return list_users;
	}

	/**
	 ** CREAR PERSONA **
	 **/
	@Override
	public void crearPersona(PersonaDTO persona){
	//public static void main(String[]args){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.PERSONA_URL + "/new";
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"dni\":\"" + persona.getDni() + "\","
													+ "\"nombre\":\"" + persona.getNombre() + "\","
													+ "\"apellidos\":\"" + persona.getApellidos() + "\","
													+ " \"nivel_id\":\"" + persona.getIdNivel() + "\","
													+ "\"horario_id\":\"" + persona.getIdHorario() +"\","
													+ "\"isUsuario\":\"" + "0" + "\"}",
													ContentType.create("application/json"));
			postRequest.setEntity(json_req);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(postRequest);

			int code = response.getStatusLine().getStatusCode();
			// Check for HTTP response code: 200 = success
			if (code != 201) {
				frame.Alert(AlertType.ERROR, "Servidor No operativo", "Operaci�n no permitida "
		    			+ "HTTP Error"+ code);
				throw new DAOExcepcion("Failed : HTTP error code : " + code);
			}

			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			System.out.println(body +","+ code);

			CloseableHttpResponse response1 = (CloseableHttpResponse) httpClient.execute(postRequest);
			response1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 ** BORRAR PERSONA **
	 **/
	@Override
	public void borrarPersona(String dni) throws DAOExcepcion {
	//public static void main(String[]args){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.PERSONA_URL + "/" + dni + "/delete";
			HttpDelete deleteRequest = new HttpDelete(url_new);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(deleteRequest);

			int code = response.getStatusLine().getStatusCode();
			// Check for HTTP response code: 200 = success
			if (code != 200) {
				throw new DAOExcepcion("Failed : HTTP error code : " + code);
			}
			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			System.out.println(body +","+ code);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}