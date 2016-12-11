package com.SecurVision.persistencia;

import java.sql.*;

import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.persistenciaDTO.ZonaDTO;

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

public class ZonaDAOImp implements IZonaDAO {

	/**
	 ** LISTAR ZONAS **
	 **/
	@Override
	public List<ZonaDTO> listarZonas(){

		List<ZonaDTO> list_zones = new ArrayList<>();
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			HttpGet getRequest = new HttpGet(Constants.ZONA_URL);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);

			int code = response.getStatusLine().getStatusCode();

			// Check for HTTP response code: 200 = success
			if (code != 200) {

				throw new DAOExcepcion("Failed : HTTP error code : " + code + response.getStatusLine());
			}

			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);

			System.out.println(body);

			JSONArray jsonArray = new JSONArray(body);

			for (int i = 0; i < jsonArray.length(); i++) {
			    JSONObject jsonobject = jsonArray.getJSONObject(i);
			    String descrip = jsonobject.getString("descripcion");
			    int id = jsonobject.getInt("zid");

			    ZonaDTO z = new ZonaDTO(id,descrip);
			    list_zones.add(z);
			}

			CloseableHttpResponse response1 = (CloseableHttpResponse) httpClient.execute(getRequest);
			response1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

      return list_zones;
	}

	/**
	 **CREAR ZONA **
	 **/
	@Override
	public void crearZona(ZonaDTO zona){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.ZONA_URL + "/new";
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"zid\":\"" + zona.getId() + "\","
													+ "\"descripcion\":\"" + zona.getDescription() + "\"}",
													ContentType.create("application/json"));
			postRequest.setEntity(json_req);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(postRequest);

			int code = response.getStatusLine().getStatusCode();
			// Check for HTTP response code: 200 = success
			if (code != 201) {

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
	 * BORRAR ZONA
	 **/
	@Override
	public void borrarZona(int id) throws DAOExcepcion {
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.ZONA_URL + "/" + id + "/delete";
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

			CloseableHttpResponse response1 = (CloseableHttpResponse) httpClient.execute(deleteRequest);
			response1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
