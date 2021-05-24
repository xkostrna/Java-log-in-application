package stuba.tomas.kostrna.oop.backend;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UsersDatabase {
    private Map<String, String> logData;

    public UsersDatabase() throws IOException {
        this.logData = new HashMap<>();
        injectMapByTextFile();
    }

    private void injectMapByTextFile() throws IOException {
        FileReader reader = new FileReader("src\\main\\java\\stuba\\tomas\\kostrna\\oop\\backend\\logdata.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int username = 0;
        int password = 1;
        String s;
        while((s = bufferedReader.readLine()) != null) {
            String[] parts = s.split(" ");
            this.logData.put(parts[username], parts[password]);
        }
    }

    private void addUserToDatabase(String name, String password) {
        this.logData.put(name, password);
    }

}
