package com.SecurVision.persistencia;

import java.sql.*;
import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.persistenciaDTO.NivelDTO;
import com.SecurVision.userInterface.Frameworks;

import javafx.scene.control.Alert.AlertType;

import com.SecurVision.exceptions.*;
import java.util.*;

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

public class NivelDAOImp implements INivelDAO {
	Frameworks frame=new Frameworks();

	/**
	 *LISTAR NIVELES
	 **/
	@Override
	public List<NivelDTO> listarNiveles() throws DAOExcepcion {
		List<NivelDTO> list_niveles = new ArrayList<>();
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
			    int id = jsonobject.getInt("id");
			    String desc = jsonobject.getString("descripcion");

			    NivelDTO n = new NivelDTO(id, desc);
			    list_niveles.add(n);
			}

			CloseableHttpResponse response1 = (CloseableHttpResponse) httpClient.execute(getRequest);
			response1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

      return list_niveles;
	}


	/**
	 *CREAR NIVEL
	 **/
	@Override
	public void crearNivel(NivelDTO nivel) throws DAOExcepcion {
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.NIVEL_URL + "/new";
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"id\":\"" + nivel.getId() + "\","
													+ "\"descripcion\":\"" + nivel.getDescripcion() + "\"}",
													ContentType.create("application/json"));
			postRequest.setEntity(json_req);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(postRequest);

			int code = response.getStatusLine().getStatusCode();
			// Check for HTTP response code: 200 = success
			if (code != 201) {
				frame.Alert(AlertType.ERROR, "Servidor No operativo", "Operaci�n no permitida "
		    			+ "HTTP Error"+ code);
				//throw new DAOExcepcion("Failed : HTTP error code : " + code);
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
	 * BORRAR NIVEL
	 **/
	@Override
	public void borrarNivel(int id) throws DAOExcepcion {
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.NIVEL_URL + "/" + id + "/delete";
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