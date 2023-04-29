
package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public enum FacialFeatures {
  CLEAN_SHAVEN, LIGHT_BEARD, HEAVY_BEARD, GOATEE, MOUSTACHE;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
