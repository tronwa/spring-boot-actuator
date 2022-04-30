package guru.springframework.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component - kommentert ut, det er ikke ønskelig å ha denne kjørende
public class RandomHealthIndicator implements HealthIndicator {

    private Random randomGenerator = new Random();

    @Override
    public Health health() {
        if (!randomGenerator.nextBoolean()) {
            return Health.down().withDetail("ERR-001", "Random failure").build();
        }
        return Health.up().build();
    }
}
