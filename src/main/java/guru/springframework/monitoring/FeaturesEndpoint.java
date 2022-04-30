package guru.springframework.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Endpoint(id = "features")
public class FeaturesEndpoint {



    private List<String> features = List.of( "flying", "Swimming", "Dancing");
    @PostConstruct
    public void addCustomInfo() {
        System.setProperty("info.app.mld", "Tron W");
    }

    @ReadOperation
    public List<String> features() {
        return features;
    }

    @ReadOperation
    public String feature(@Selector Integer id) {
        return (id >= features.size() ? "" : features.get(id));
    }
}
