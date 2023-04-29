
package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;


public class Knight implements Characters {
   private String name;
   private Avatar avatar;
    
    public Knight(String name){
        if (name == null ) {
            throw new IllegalArgumentException("Character must have a name");
        }
        this.name=name;
        this.avatar=new Avatar(SkinTone.MEDIUM, HairType.LONG_STRAIGHT, HairColor.BLACK, BodyType.MUSCULAR, FacialFeatures.LIGHT_BEARD);
    }
    public String getName(){
        return this.name;
    }
    
    public Avatar getAvatar(){
        return this.avatar;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setAvatar(Avatar avatar){
        this.avatar=avatar;
    }

    public String toString(){
        return this.name+" has "+this.avatar.toString();
    }
}

