
package com.mycompany.factorybuilder;

public class FlagBearer implements Characters{
  private String name;
    private Avatar avatar;
    
    public FlagBearer(String name){
        if (name == null ) {
            throw new IllegalArgumentException("Character must have a name");
        }
        this.name=name;
        this.avatar=new Avatar(SkinTone.LIGHT, HairType.CURLY, HairColor.BROWN, BodyType.SKINNY,FacialFeatures.GOATEE);
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