package ua.lviv.iot.christmasfair.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.DecorBoxRepository;
import ua.lviv.iot.christmasfair.model.DecorBox;

@Service
public class DecorBoxService extends AbstractService<DecorBox> {
  
  @Autowired
  private DecorBoxRepository decorBoxRepository;

  @Override
  protected JpaRepository<DecorBox, Integer> getRepository() {
    return decorBoxRepository;
  }
  
  
}
