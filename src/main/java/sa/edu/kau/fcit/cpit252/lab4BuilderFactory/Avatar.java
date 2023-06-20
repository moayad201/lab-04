

package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public final class Avatar {

  private final SkinTone skinTone;
  private final HairType hairType;
  private final HairColor hairColor;
  private final BodyType bodyType;
  private final FacialFeatures facialFeatures;

  private Avatar(Builder builder) {
    this.skinTone = builder.skinTone;
    this.hairType = builder.hairType;
    this.hairColor = builder.hairColor;
    this.bodyType = builder.bodyType;
    this.facialFeatures = builder.facialFeatures;
  }

  public SkinTone getSkinTone() {
    return skinTone;
  }

  public HairType getHairType() {
    return hairType;
  }

  public HairColor getHairColor() {
    return hairColor;
  }

  public BodyType getBodyType() {
    return bodyType;
  }

  public FacialFeatures getFacialFeatures() {
    return facialFeatures;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append(skinTone).append(" skin color");
    if (hairColor != null || hairType != null) {
      sb.append(" with ");
      if (hairColor != null) {
        sb.append(hairColor).append(' ');
      }
      if (hairType != null) {
        sb.append(hairType).append(' ');
      }
      sb.append(hairType != HairType.BALD ? "hair" : " head");
    }
    if (bodyType != null) {
      sb.append(" and a ").append(bodyType).append(" body");
    }
    if (facialFeatures != null) {
      sb.append(" and a ").append(facialFeatures);
    }
    sb.append('.');
    return sb.toString();
  }

  public static class Builder{
    private final SkinTone skinTone;
    private  HairType hairType;
    private  HairColor hairColor;
    private  BodyType bodyType;
    private  FacialFeatures facialFeatures;


    public Builder(SkinTone skinTone){
      if(skinTone == null){
        throw new IllegalArgumentException("Skin tone is required");
      }
      this.skinTone = skinTone;
    }
    public Builder withHairType(HairType hairType) {
      this.hairType = hairType;
      return this;
    }
    public Builder withHairColor(HairColor hairColor) {
      this.hairColor = hairColor;
      return this;
    }
    public Builder withBodyType(BodyType bodyType) {
      this.bodyType = bodyType;
      return this;
    }
    public Builder withFacialFeatures(FacialFeatures facialFeatures) {
      this.facialFeatures = facialFeatures;
      return this;
    }
    public Avatar build(){
      return new Avatar(this);
    }

  }
}