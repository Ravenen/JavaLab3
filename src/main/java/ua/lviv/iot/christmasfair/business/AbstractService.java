package ua.lviv.iot.christmasfair.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> {

  protected abstract JpaRepository<T, Integer> getRepository();

  public T createObject(T object) {
    return getRepository().save(object);
  }

  public T getObject(Integer objectId) {
    return getRepository().findById(objectId).orElse(null);
  }

  public List<T> getAllObjects() {
    return getRepository().findAll();
  }

  public T updateObject(Integer objectId, T object, T oldObject) {
    T foundObject = getRepository().findById(objectId).orElse(null);
    if (foundObject != null) {
      BeanUtils.copyProperties(foundObject, oldObject);
      getRepository().save(object);
    }
    return oldObject;
  }

  public boolean deleteObject(Integer objectId) {
    if (getRepository().existsById(objectId)) {
      getRepository().deleteById(objectId);
      return true;
    } else {
      return false;
    }
  }

}
