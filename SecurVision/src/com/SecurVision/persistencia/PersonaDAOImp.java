package com.SecurVision.persistencia;

import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.exceptions.*;

import java.util.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

public class PersonaDAOImp implements IPersonaDAO {
	 Client client = ClientBuilder.newClient();
	 String jsonGet;
	 Response jsonPost;

	@Override
	public List<PersonaDTO> getListaPersonas(){

        return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void crearPersona(PersonaDTO p) throws DAOExcepcion {
		String listperson_url = Constants.PERSONA_URL + "new";
		WebTarget target = client.target(listperson_url);

		JSONObject jsonRequest= new JSONObject();
		jsonRequest.put("dni", "123456");
		jsonRequest.put("nombre", "Prueba");
		jsonRequest.put("apellidos", "Prueba");
		jsonRequest.put("nivel_id", "1");
		jsonRequest.put("horario_id", "1");
		jsonRequest.put("isUsuario", "0");

       // jsonResponse = target.request().get(String.class);
       // System.out.println("All users : "+ jsonResponse);

     jsonPost = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(jsonRequest));
      System.out.println("customer created with id: "+jsonPost);


	}
}