package ua.lviv.iot.christmasfair.model;

import java.util.EnumSet;

public class Garland extends AbstractDecor {
  private double lengthInMetres;
  private boolean isNatural;

  public Garland(String color, double priceInHryvnas, EnumSet<DecorationType> type, double lengthInMenter,
      boolean isNatural) {
    super(color, priceInHryvnas, type);
    this.lengthInMetres = lengthInMenter;
    this.isNatural = isNatural;
  }

  public double getLengthInMetres() {
    return lengthInMetres;
  }

  public void setLengthInMetres(double lengthInMetres) {
    this.lengthInMetres = lengthInMetres;
  }

  public boolean isNatural() {
    return isNatural;
  }

  public void setNatural(boolean isNatural) {
    this.isNatural = isNatural;
  }

  public String getHeaders() {
    return super.getHeaders() + ", lengthInMetres, isNatural";
  }

  public String toCSV() {
    return super.toCSV() + ", " + lengthInMetres + ", " + isNatural;
  }

  @Override
  public String toString() {
    return "Garland [lengthInMetres=" + lengthInMetres + ", isNatural=" + isNatural + super.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (isNatural ? 1231 : 1237);
    long temp;
    temp = Double.doubleToLongBits(lengthInMetres);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Garland other = (Garland) obj;
    if (isNatural != other.isNatural) {
      return false;
    }
    if (Double.doubleToLongBits(lengthInMetres) != Double.doubleToLongBits(other.lengthInMetres)) {
      return false;
    }
    return true;
  }

}
