package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;


public enum SkinTone {
  FAIR, LIGHT, MEDIUM , DARK;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
