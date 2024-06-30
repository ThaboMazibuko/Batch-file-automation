package automationTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SignIncredentials {
    private String[] credentials;

    public SignIncredentials(String filePath) throws IOException {
        this.credentials = readCredentials(filePath);
    }

    private String[] readCredentials(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] credentials = new String[11];
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < 11) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    credentials[index++] = parts[1].trim();
                }
            }
            return credentials;
        }
    }

    public String[] getCredentials() {
        return credentials;
    }
}
