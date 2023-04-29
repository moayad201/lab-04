

package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public enum HairColor {
  WHITE, BLOND, RED, BROWN, BLACK;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
