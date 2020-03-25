package ua.lviv.iot.christmasfair.controller;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.christmasfair.model.DecorationType;
import ua.lviv.iot.christmasfair.model.Light;

@RequestMapping("/lights")
@RestController
public class LightsController {

  private Map<Integer, Light> lights = new HashMap<Integer, Light>();
  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Light> getAllLights() {
    return new LinkedList<Light>(lights.values());
  }

  @GetMapping("/temp")
  public Light getTeplate() {
    return new Light("red", 25.5, EnumSet.of(DecorationType.DOOR), 220.0, 20);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Light> getLight(final @PathVariable("id") Integer lightId) {
    Light currentLight;
    ResponseEntity<Light> response = (currentLight = lights.get(lightId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(currentLight, HttpStatus.OK);
    return response;
  }

  @PostMapping
  public Light createLight(final @RequestBody Light light) {
    light.setId(idCounter.incrementAndGet());
    lights.put(light.getId(), light);
    return light;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Light> updateLight(final @PathVariable("id") Integer lightId, final @RequestBody Light light) {
    light.setId(lightId);
    ResponseEntity<Light> response = lights.replace(lightId, light) == null
        ? new ResponseEntity<Light>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Light>(light, HttpStatus.OK);
    return response;
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Light> deleteLight(final @PathVariable("id") Integer lightId) {
    HttpStatus status = lights.remove(lightId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return new ResponseEntity<Light>(status);
  }
}
