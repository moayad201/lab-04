
package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;


public enum CharacterTypes {
  ARCHER,FLAG_BEARER,KNIGHT;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
