package ua.lviv.iot.christmasfair.model;

import java.util.EnumSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractDecor {

  private static final int DEFAULT_YEAR_OF_PRODUCTION = 1970;
  private static final String DEFAULT_PRODUCER = "Unknown Chinese Producer";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Integer id;
  protected String color;
  protected double priceInHryvnas;
  protected String producer;
  protected int yearOfProduction;
  @Column
  @ElementCollection(targetClass = DecorationType.class)
  protected Set<DecorationType> type;
  
//  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DecorBox.class)
//  @JoinColumn(name = "box_id")
//  @JsonIgnoreProperties("decorations")
//  protected DecorBox box;
//  
//  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Viewer.class)
//  @JoinTable(name = "Decor_Viewers", joinColumns = {
//      @JoinColumn(name = "decor_id", nullable = false) }, inverseJoinColumns = {
//          @JoinColumn(name = "viewer_id", nullable = false) })
//  @JsonIgnoreProperties("observedDecorations")
//  protected Set<Viewer> viewers;

  public AbstractDecor() {

  }

  public AbstractDecor(String color, double priceInHryvnas, EnumSet<DecorationType> type) {
    this(color, priceInHryvnas, type, DEFAULT_PRODUCER, DEFAULT_YEAR_OF_PRODUCTION);
  }

  public AbstractDecor(String color, double priceInHryvnas, EnumSet<DecorationType> type, String producer,
      int yearOfProduction) {
    super();
    this.color = color;
    this.priceInHryvnas = priceInHryvnas;
    this.type = type;
    this.producer = producer;
    this.yearOfProduction = yearOfProduction;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public int getYearOfProduction() {
    return yearOfProduction;
  }

  public void setYearOfProduction(int yearOfProduction) {
    this.yearOfProduction = yearOfProduction;
  }

  public boolean checkCriterion(EnumSet<DecorationType> criterion) {
    return this.type.containsAll(criterion);
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getPriceInHryvnas() {
    return priceInHryvnas;
  }

  public void setPriceInHryvnas(double priceInHryvnas) {
    this.priceInHryvnas = priceInHryvnas;
  }

  public Set<DecorationType> getType() {
    return type;
  }

  public void setType(EnumSet<DecorationType> type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

//  public DecorBox getBox() {
//    return box;
//  }
//
//  public void setBox(DecorBox box) {
//    this.box = box;
//  }
//
//  public Set<Viewer> getViewers() {
//    return viewers;
//  }
//
//  public void setViewers(Set<Viewer> viewers) {
//    this.viewers = viewers;
//  }

  public String getHeaders() {
    return "color, priceInHryvnas, producer, yearOfProduction, type";
  }

  public String toCSV() {
    return color + ", " + priceInHryvnas + ", " + producer + ", " + type;
  }

  @Override
  public String toString() {
    return "color=" + color + ", priceInHryvnas=" + priceInHryvnas + ", producer=" + producer + ", yearOfProduction="
        + yearOfProduction + ", type=" + type + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    long temp;
    temp = Double.doubleToLongBits(priceInHryvnas);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AbstractDecor other = (AbstractDecor) obj;
    if (color == null) {
      if (other.color != null) {
        return false;
      }
    } else if (!color.equals(other.color)) {
      return false;
    }
    if (Double.doubleToLongBits(priceInHryvnas) != Double.doubleToLongBits(other.priceInHryvnas)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }

}
