package ua.lviv.iot.christmasfair.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Viewer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private String firstName;
  private String secondName;
  @ManyToMany(mappedBy = "viewers", fetch = FetchType.EAGER, targetEntity = Light.class)
  @JsonIgnoreProperties("viewers")
  private Set<Light> observedDecorations;

  public Viewer() {
    
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public Set<Light> getObservedDecorations() {
    return observedDecorations;
  }

  public void setObservedDecorations(Set<Light> observedDecorations) {
    this.observedDecorations = observedDecorations;
  }

}
