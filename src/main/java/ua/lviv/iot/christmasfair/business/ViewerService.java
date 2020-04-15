package ua.lviv.iot.christmasfair.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.ViewerRepository;
import ua.lviv.iot.christmasfair.model.Viewer;

@Service
public class ViewerService extends AbstractService<Viewer> {
  
  @Autowired
  private ViewerRepository viewerRepository;

  @Override
  protected JpaRepository<Viewer, Integer> getRepository() {
    return viewerRepository;
  }
  
  
}
