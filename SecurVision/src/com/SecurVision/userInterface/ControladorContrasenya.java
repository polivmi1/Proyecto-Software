package com.SecurVision.userInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ControladorContrasenya {


	@FXML
	private PasswordField passOld;

	@FXML
	private PasswordField passNew;

	@FXML
	private PasswordField passNewRep;


	private static File targetFile;
	private static Properties properties;
	private static String newLine = System.lineSeparator();



	public ControladorContrasenya(){
	}


	@FXML
	private void initialize() throws IOException{
		if(!targetFile.exists())
			targetFile.createNewFile();


//		Boolean doesTheKeyValuePairExist = 
//				checkIfKeyValuePairExists(
//						"root", "1234");
//
//		if(!doesTheKeyValuePairExist)
//			addNewCredentials(
//					"admin", passNew.getText());
//		else{
//			System.out.println("existe");
//		}


	}

	@FXML
	void aceptar(ActionEvent event) throws IOException {
		Boolean doesTheKeyValuePairExist = 
				checkIfKeyValuePairExists(
						"admin",passOld.getText());
		if(doesTheKeyValuePairExist)
			addNewCredentials(
					"admin", passNew.getText());
		else{
			System.out.println("No existe");
		}

	}  

	static
	{
		targetFile = new File("./password");

		properties = new Properties();

		try
		{
			properties.load(
					new FileInputStream(
							targetFile.getAbsolutePath()));
		}

		catch(IOException ioe)
		{
			System.err.println(
					"Unable to read file.");
		}
	}

	private static void addNewCredentials(
			String username, String password)
					throws IOException
	{
		FileWriter writer = 
				new FileWriter(
						targetFile.getAbsolutePath()
						, true);
		Writer output = 
				new BufferedWriter(writer);
		output.write(
				newLine + username + ":" + password);
		output.close();
	}

	private static Boolean checkIfKeyValuePairExists(
			String username, String password
			)
	{
		for(String key: 
			properties.stringPropertyNames())
			if(key.equals(username) 
					&& properties.getProperty(key)
					.equals(password))
				return true;

		return false;
	}

}
