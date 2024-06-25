package scripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readData {
	
    public static String[] readShippingAddressDataFromFile() {
	    String filePath = "data/shippingAddressData";
	    String[] shippingAddressData = new String[9];

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        for (int i = 0; i < 9; i++) {
	            shippingAddressData[i] = br.readLine();
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading data from file: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return shippingAddressData;
	}

    // Method to read registration data from a file and return it as an array
    public static String[] readRegistrationDataFromFile() {
        String filePath = "data/createAcc.txt";
        String[] registrationData = new String[5];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < 5; i++) {
                registrationData[i] = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
            e.printStackTrace();
        }

        return registrationData;
    }
    public static String readLinkFromFile(){
    	String filePath = "data/link.txt";
      //  String[] link = new String[6];
    	String lk = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           
           lk = br.readLine();
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
            e.printStackTrace();
        }
        return lk;
    }

    // Method to read sign-in data from a file and return it as an array
    public static String[] readSignInDataFromFile() {
        String filePath = "data/SignIn.txt";
        String[] signInData = new String[2];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < 2; i++) {
                signInData[i] = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
            e.printStackTrace();
        }

        return signInData;
    }


}

