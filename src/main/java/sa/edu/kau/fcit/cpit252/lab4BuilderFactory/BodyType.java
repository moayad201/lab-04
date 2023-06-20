package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public enum BodyType {
  SKINNY, FIT,  MUSCULAR, FAT;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}