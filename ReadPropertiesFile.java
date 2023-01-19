package com.Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import BasePackage.BaseClass;

public class ReadPropertiesFile extends BaseClass{
   
		
	/******************************************************************************************************	
 	Function Name:-> loadElementSelectorFile
	Description  :-> Read properties file for element selectors
	Input Param  :-> 
	Outpur Param :->
	*******************************************************************************************************/
	public Properties loadElementSelectorFile()
	{
		
		eleconfig = new Properties();
		System.out.println("ElementFilePath "+ElementFilePath);
		try{
			FileInputStream fs = null;
			fs = new FileInputStream(ElementFilePath);
			
			eleconfig.load(fs);   //load the config file
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return eleconfig;
	}
	
	
	/******************************************************************************************************	
 	Function Name:-> loadDetails()System.out.println("ElementFilePath "+ElementFilePath);
	Description  :-> Read properties file for Application Details
	Input Param  :->
	Outpur Param :->
	*******************************************************************************************************/
	public Properties loadDetails()
	{
		
		detailsconfig = new Properties();
		System.out.println("detailsconfig "+detailsconfig);
		try{
			
				FileInputStream fs = new FileInputStream(DetailsFilePath);
				
				detailsconfig.load(fs);    //load the config file
		}catch(Exception e){
			e.printStackTrace();	
		}
		return detailsconfig;
	}
}
