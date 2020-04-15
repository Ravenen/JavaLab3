package ua.lviv.iot.christmasfair.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
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
import ua.lviv.iot.christmasfair.business.LightService;
import ua.lviv.iot.christmasfair.model.Light;

@RequestMapping("/lights")
@RestController
public class LightsController {

  @Autowired
  private LightService lightService;
  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Light> getAllLights() {
    return lightService.getAllObjects();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Light> getObject(final @PathVariable("id") Integer lightId) {
    Light currentLight;
    ResponseEntity<Light> response = (currentLight = lightService.getObject(lightId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(currentLight, HttpStatus.OK);
    return response;
  }

  @PostMapping
  public Light createObject(final @RequestBody Light light) {
    light.setId(idCounter.incrementAndGet());
    lightService.createObject(light);
    return light;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Light> updateObject(final @PathVariable("id") Integer lightId, final @RequestBody Light light) {
    light.setId(lightId);
    Light oldLight;
    ResponseEntity<Light> response = (oldLight = lightService.updateObject(lightId, light, new Light())) == null
        ? new ResponseEntity<Light>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Light>(oldLight, HttpStatus.OK);
    return response;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Light> deleteObject(final @PathVariable("id") Integer lightId) {
    HttpStatus status = lightService.deleteObject(lightId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<Light>(status);
  }
}
