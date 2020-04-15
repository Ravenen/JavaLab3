package ua.lviv.iot.christmasfair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DecorBox {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private double volume;
  @OneToMany(mappedBy = "box", fetch = FetchType.EAGER, targetEntity = Light.class)
  @JsonIgnoreProperties("box")
  private Set<Light> decorations;

  public DecorBox() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }

  public Set<Light> getDecorations() {
    return decorations;
  }

  public void setDecorations(Set<Light> decorations) {
    this.decorations = decorations;
  }
}
