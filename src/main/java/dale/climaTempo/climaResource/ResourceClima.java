package dale.climaTempo.climaResource;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class ResourceClima {

    @Autowired
    private Service service;

    @GetMapping("/tempo")
    public ClimaTempoResponse getTempo(){
        ClimaTempoResponse tempo = null;
        try {
            String body = service.getClimaTempo().body();
            Gson gson = new Gson();
            tempo = gson.fromJson(body, ClimaTempoResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return tempo;
    }
}
