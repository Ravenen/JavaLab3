package ua.lviv.iot.christmasfair.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.LightRepository;
import ua.lviv.iot.christmasfair.model.Light;

@Service
public class LightService {

  @Autowired
  private LightRepository lightRepository;
  
  public Light createLight(Light light) {
    return lightRepository.save(light);
  }
  
  public Light getLight(Integer lightId) {
    return lightRepository.findById(lightId).get();
  }
  
  public List<Light> getAllLights() {
    return lightRepository.findAll();
  }
  
  public Light updateLight(Integer lightId, Light light) {
    Light oldLight = lightRepository.findById(lightId).get();
    if (oldLight != null) {
      lightRepository.save(light);
    }
    return oldLight;
  }
  
  public Light deleteLight(Integer lightId) {
    Light foundLight = lightRepository.findById(lightId).get();
    if (foundLight != null) {
      lightRepository.deleteById(lightId);
    }
    return foundLight;
  }
}
