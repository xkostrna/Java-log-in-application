package stuba.tomas.kostrna.oop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Application();
        }
        catch (IOException e) {
            System.out.println("Not found");
        }
    }
}
