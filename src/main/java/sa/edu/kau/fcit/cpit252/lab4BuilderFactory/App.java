package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public class App {

  public static void main(String[] args) {
    Knight knight = new Knight("Aragorn");
    System.out.println(knight.toString());

    Archer archer = new Archer("Legolas");
    System.out.println(archer.toString());
    
    FlagBearer flagBearer = new FlagBearer("Frodo");
    System.out.println(flagBearer.toString());
  }
}
