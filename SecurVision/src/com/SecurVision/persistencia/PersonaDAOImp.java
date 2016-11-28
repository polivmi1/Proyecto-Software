package com.SecurVision.persistencia;

import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.exceptions.*;

import java.util.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PersonaDAOImp implements IPersonaDAO {

	@Override
	public List<PersonaDTO> getListaPersonas(){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.PERSONA_URL + "/listar";
			HttpGet getRequest = new HttpGet(url_new);

			// Add additional header to getRequest which accepts application/xml data
			// getRequest.addHeader("Content-Type", "application/json");

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);
			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);
			int code = response.getStatusLine().getStatusCode();

			// Check for HTTP response code: 200 = success
			if (code != 200) {
				throw new DAOExcepcion("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			System.out.println(body +","+ code);

			// Get-Capture Complete application/json body response
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

        return null;
	}

	//@Override
	//public void crearPersona(PersonaDTO persona){
	public static void main(String[]args){
		try{
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.PERSONA_URL + "/new";
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"dni\":\"" + "234eds" + "\","
													+ "\"nombre\":\"" + "e"+ "\","
													+ "\"apellidos\":\"" + "e" + "\","
													+ " \"nivel_id\":\"" + "1" + "\","
													+ "\"horario_id\":\"" + "1" +"\","
													+ "\"isUsuario\":\"" + "1" + "\"}",
													ContentType.create("application/json"));
			postRequest.setEntity(json_req);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(postRequest);
			ResponseHandler<String> handler = new BasicResponseHandler();
			String body = handler.handleResponse(response);
			int code = response.getStatusLine().getStatusCode();

			// Check for HTTP response code: 200 = success
			if (code != 201) {
				throw new DAOExcepcion("Failed : HTTP error code : " + code);
			}
			System.out.println(body +","+ code);

			// Get-Capture Complete application/json body response
			/*BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}