package ua.lviv.iot.christmasfair.model;

import java.util.EnumSet;

public class TreeToy extends AbstractDecor {
  private String form;
  private int volumeInCmCube;

  public TreeToy(String color, double priceInHryvnas, EnumSet<DecorationType> type, String form, int volumeInCmCube) {
    super(color, priceInHryvnas, type);
    this.form = form;
    this.volumeInCmCube = volumeInCmCube;
  }

  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public int getVolumeInCmCube() {
    return volumeInCmCube;
  }

  public void setVolumeInCmCube(int volumeInCmCube) {
    this.volumeInCmCube = volumeInCmCube;
  }

  public String getHeaders() {
    return super.getHeaders() + ", form, volumeInCmCube";
  }

  public String toCSV() {
    return super.toCSV() + ", " + form + ", " + volumeInCmCube;
  }

  @Override
  public String toString() {
    return "TreeToy [form=" + form + ", volumeInCmCube=" + volumeInCmCube + super.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((form == null) ? 0 : form.hashCode());
    result = prime * result + volumeInCmCube;
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
    TreeToy other = (TreeToy) obj;
    if (form == null) {
      if (other.form != null) {
        return false;
      }
    } else if (!form.equals(other.form)) {
      return false;
    }
    if (volumeInCmCube != other.volumeInCmCube) {
      return false;
    }
    return true;
  }

}
