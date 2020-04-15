package ua.lviv.iot.christmasfair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.EnumSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Light extends AbstractDecor {
  private double maxVoltage;
  private int numberOfBulbs;
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DecorBox.class)
  @JoinColumn(name = "box_id")
  @JsonIgnoreProperties("decorations")
  protected DecorBox box;
  
  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Viewer.class)
  @JoinTable(name = "Decor_Viewers", joinColumns = {
      @JoinColumn(name = "decor_id", nullable = false) }, inverseJoinColumns = {
          @JoinColumn(name = "viewer_id", nullable = false) })
  @JsonIgnoreProperties("observedDecorations")
  protected Set<Viewer> viewers;
  
  public Light() {
    super();
  }

  public Light(String color, double priceInHryvnas, EnumSet<DecorationType> type, double maxVoltage,
      int numberOfBulbs) {
    super(color, priceInHryvnas, type);
    this.maxVoltage = maxVoltage;
    this.numberOfBulbs = numberOfBulbs;
  }

  public double getMaxVoltage() {
    return maxVoltage;
  }

  public void setMaxVoltage(double maxVoltage) {
    this.maxVoltage = maxVoltage;
  }

  public int getNumberOfBulbs() {
    return numberOfBulbs;
  }

  public void setNumberOfBulbs(int numberOfBulbs) {
    this.numberOfBulbs = numberOfBulbs;
  }

  public DecorBox getBox() {
    return box;
  }

  public void setBox(DecorBox box) {
    this.box = box;
  }

  public Set<Viewer> getViewers() {
    return viewers;
  }

  public void setViewers(Set<Viewer> viewers) {
    this.viewers = viewers;
  }

  public String getHeaders() {
    return super.getHeaders() + ", maxVoltage, numberOfBulbs";
  }

  public String toCSV() {
    return super.toCSV() + ", " + maxVoltage + ", " + numberOfBulbs;
  }

  @Override
  public String toString() {
    return "Light [maxVoltage=" + maxVoltage + ", numberOfBulbs=" + numberOfBulbs + super.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(maxVoltage);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + numberOfBulbs;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Light other = (Light) obj;
    if (Double.doubleToLongBits(maxVoltage) != Double.doubleToLongBits(other.maxVoltage)) {
      return false;
    }
    if (numberOfBulbs != other.numberOfBulbs) {
      return false;
    }
    return true;
  }

}
