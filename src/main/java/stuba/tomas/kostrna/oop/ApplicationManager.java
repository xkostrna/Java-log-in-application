package stuba.tomas.kostrna.oop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationManager {
    private final Application application;

    public ApplicationManager(Application application) {
        this.application = application;
    }
}
