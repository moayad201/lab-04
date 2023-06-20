
package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public class FlagBearer implements Characters{
    private String name;
    private Avatar avatar;

    public FlagBearer(String name){
        if (name == null ) {
            throw new IllegalArgumentException("Character must have a name");
        }
        this.name=name;
        this.avatar=new Avatar.Builder(SkinTone.FAIR).withHairType(HairType.SHORT).withHairColor(HairColor.BROWN).withBodyType(BodyType.SKINNY).withFacialFeatures(FacialFeatures.LIGHT_BEARD).build();
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