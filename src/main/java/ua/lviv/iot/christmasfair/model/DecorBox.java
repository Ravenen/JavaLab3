package ua.lviv.iot.christmasfair.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DecorBox {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private double volume;
  private Set<AbstractDecor> decorations;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }

  public Set<AbstractDecor> getDecorations() {
    return decorations;
  }

  public void setDecorations(Set<AbstractDecor> decorations) {
    this.decorations = decorations;
  }
}
