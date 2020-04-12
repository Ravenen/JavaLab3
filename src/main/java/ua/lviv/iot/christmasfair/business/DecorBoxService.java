package ua.lviv.iot.christmasfair.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.christmasfair.dataaccess.DecorBoxRepository;
import ua.lviv.iot.christmasfair.model.DecorBox;

@Service
public class DecorBoxService {
  
  @Autowired
  private DecorBoxRepository decorBoxRepository;
  
  public DecorBox createBox(DecorBox box) {
    return decorBoxRepository.save(box);
  }

  public DecorBox getBox(Integer boxId) {
    return decorBoxRepository.findById(boxId).orElse(null);
  }

  public List<DecorBox> getAllBoxes() {
    return decorBoxRepository.findAll();
  }

  public DecorBox updateBox(Integer boxId, DecorBox box) {
    DecorBox oldBox = null;
    DecorBox foundBox = decorBoxRepository.findById(boxId).orElse(null);
    if (foundBox != null) {
      oldBox = new DecorBox();
      BeanUtils.copyProperties(foundBox, oldBox);
      decorBoxRepository.save(box);
    }
    return oldBox;
  }

  public boolean deleteBox(Integer boxId) {
    if (decorBoxRepository.existsById(boxId)) {
      decorBoxRepository.deleteById(boxId);
      return true;
    } else {
      return false;
    }
  }
}
