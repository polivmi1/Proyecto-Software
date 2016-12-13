package com.SecurVision.persistencia;

import java.sql.*;
import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.persistenciaDTO.UsuarioDTO;
import com.SecurVision.userInterface.Frameworks;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.SecurVision.exceptions.*;
import java.util.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class UsuarioDAOImp implements IUsuarioDAO {

	Frameworks frame=new Frameworks();

	/**
	 ** CREAR USUARIO **
	 **/
	@Override
	public void crearUsuario(UsuarioDTO usuario){
	//public static void main(String[]args){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.USUARIO_URL + "/new";
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"dni\":\"" + usuario.getDni() + "\","
													+ "\"nombre\":\"" + usuario.getNombre() + "\","
													+ "\"apellidos\":\"" + usuario.getApellidos() + "\","
													+ " \"username\":\"" + usuario.getUsername() + "\","
													+ "\"password\":\"" + usuario.getPassword() +"\","
													+ "\"tipo\":\"" + "1" + "\"}",
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
	 ** BORRAR USUARIO **
	 **/
	@Override
	public void borrarUsuario(String dni) throws DAOExcepcion {
	//public static void main(String[]args){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.USUARIO_URL + "/" + dni + "/delete";
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
