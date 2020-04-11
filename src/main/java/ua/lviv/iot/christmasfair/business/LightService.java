package ua.lviv.iot.christmasfair.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
    return lightRepository.findById(lightId).orElse(null);
  }

  public List<Light> getAllLights() {
    return lightRepository.findAll();
  }

  public Light updateLight(Integer lightId, Light light) {
    Light oldLight = null;
    Light foundLight = lightRepository.findById(lightId).orElse(null);
    if (foundLight != null) {
      oldLight = new Light();
      BeanUtils.copyProperties(foundLight, oldLight);
      lightRepository.save(light);
    }
    return oldLight;
  }

  public boolean deleteLight(Integer lightId) {
    if (lightRepository.existsById(lightId)) {
      lightRepository.deleteById(lightId);
      return true;
    } else {
      return false;
    }
  }
}
