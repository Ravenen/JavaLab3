package ua.lviv.iot.christmasfair.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.ViewerRepository;
import ua.lviv.iot.christmasfair.model.Viewer;

@Service
public class ViewerService {
  
  @Autowired
  private ViewerRepository viewerRepository;
  
  public Viewer createViewer(Viewer viewer) {
    return viewerRepository.save(viewer);
  }

  public Viewer getViewer(Integer viewerId) {
    return viewerRepository.findById(viewerId).orElse(null);
  }

  public List<Viewer> getAllViewers() {
    return viewerRepository.findAll();
  }

  public Viewer updateViewer(Integer viewerId, Viewer viewer) {
    Viewer oldViewer = null;
    Viewer foundViewer = viewerRepository.findById(viewerId).orElse(null);
    if (foundViewer != null) {
      oldViewer = new Viewer();
      BeanUtils.copyProperties(foundViewer, oldViewer);
      viewerRepository.save(viewer);
    }
    return oldViewer;
  }

  public boolean deleteViewer(Integer viewerId) {
    if (viewerRepository.existsById(viewerId)) {
      viewerRepository.deleteById(viewerId);
      return true;
    } else {
      return false;
    }
  }

}
