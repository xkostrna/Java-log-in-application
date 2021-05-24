package stuba.tomas.kostrna.oop;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.frontend.MainWindow;

import java.io.IOException;

@Getter
@Setter
public class Application {
    private MainWindow mainWindow;

    public Application() {
        try {
            this.mainWindow = new MainWindow();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
