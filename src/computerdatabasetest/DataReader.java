/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerdatabasetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sreer
 */
public class DataReader {
    public Properties getThemAll() {

	Properties prop = new Properties();
	InputStream input = null;

	try {

		String filename = System.getProperty("user.dir").concat("\\resources\\testData.properties");
                input = new FileInputStream(filename);
		prop.load(input);                
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
                if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
    }
}
