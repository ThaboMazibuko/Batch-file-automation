package luma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readData {
	  // Method to read data from file
    public static String[] readCredentials(String filePath, int size) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] credentials = new String[size];
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < size) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    credentials[index++] = parts[1].trim();
                }
            }
            return credentials;
        }
    }
}
