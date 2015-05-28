package Projekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;


public class BenutzerProjekt extends JFrame implements Serializable{
	
	private String name;
	private String urlProjekt;
	private String urlAufnahmen;
	private String urlSamples;
	
	
	public BenutzerProjekt(String projektURL, String name) {
		
		this.name = name;
		this.urlProjekt = projektURL +"/" +name;
		this.urlAufnahmen = urlProjekt +"/Aufnahmen";
		this.urlSamples = urlProjekt +"/Samples";
		
		if (!new File(urlProjekt).mkdir()){
			Exception e = new Exception();
			e.printStackTrace();
		}
		
		if (!new File(urlAufnahmen).mkdir()){
			Exception e = new Exception();
			e.printStackTrace();
		}
		
		if (!new File(urlSamples).mkdir()){
			Exception e = new Exception();
			e.printStackTrace();
		}
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(urlProjekt +"/projectfile.bin"));
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public String getUrlAufnahmen() {
		return urlAufnahmen;
	}

	public String getProjektName(){
		return name;
	}
	
	public String getUrlSamples(){
		return urlSamples;
	}
	
}
