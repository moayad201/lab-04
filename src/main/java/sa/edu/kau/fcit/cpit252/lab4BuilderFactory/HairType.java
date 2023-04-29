

package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public enum HairType {
  BALD,SHORT,CURLY, LONG_STRAIGHT, LONG_CURLY;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
