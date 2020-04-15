package ua.lviv.iot.christmasfair.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.LightRepository;
import ua.lviv.iot.christmasfair.model.Light;

@Service
public class LightService extends AbstractService<Light> {

  @Autowired
  private LightRepository lightRepository;

  @Override
  protected JpaRepository<Light, Integer> getRepository() {
    return lightRepository;
  }

}
