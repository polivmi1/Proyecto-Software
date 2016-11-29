package com.SecurVision.persistencia;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.persistenciaDTO.Constants;
import com.SecurVision.persistenciaDTO.ImagenDTO;

public class ImagenDAOImp implements IImagenDAO{

	@Override
	public void subirImagen(ImagenDTO image) throws DAOExcepcion {}
	public static void main(String[]args){
		try{
			//image.getUrl()
			// transform  file to base 64
			FileInputStream i = new FileInputStream(new File("/Users/path/Desktop/patri.jpg"));
	        byte[] message = IOUtils.toByteArray(i);
	        String encoded = DatatypeConverter.printBase64Binary(message);

			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			String url_new = Constants.IMAGEN_URL;
			HttpPost postRequest = new HttpPost(url_new);
			StringEntity json_req = new StringEntity("{\"dni\":\"" + "23822698B" + "\","
													+ "\"imagen\":\"" + encoded + "\"}",
													ContentType.create("application/json"));
			postRequest.setEntity(json_req);

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(postRequest);

			// Check for HTTP response code: 200 = success
			int code = response.getStatusLine().getStatusCode();
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

}
