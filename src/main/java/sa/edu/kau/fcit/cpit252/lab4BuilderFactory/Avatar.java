

package sa.edu.kau.fcit.cpit252.lab4BuilderFactory;

public final class Avatar {

  private final SkinTone skinTone;
  private final HairType hairType;
  private final HairColor hairColor;
  private final BodyType bodyType;
  private final FacialFeatures facialFeatures;

  public Avatar(SkinTone skinTone, HairType hairType, HairColor hairColor, BodyType bodyType, FacialFeatures facialFeatures) {
    this.skinTone = skinTone;
    this.hairType = hairType;
    this.hairColor = hairColor;
    this.bodyType = bodyType;
    this.facialFeatures = facialFeatures;
  }

  public Avatar(SkinTone skinTone, HairType hairType) {
    this(skinTone, hairType, HairColor.BLACK, BodyType.FIT, FacialFeatures.CLEAN_SHAVEN);
  }

  public Avatar(SkinTone skinTone, HairType hairType, HairColor hairColor) {
    this(skinTone, hairType, hairColor, BodyType.FIT, FacialFeatures.CLEAN_SHAVEN);
  }

  public Avatar(SkinTone skinTone, HairType hairType, HairColor hairColor, BodyType bodyType) {
    this(skinTone, hairType, hairColor, bodyType, FacialFeatures.CLEAN_SHAVEN);
  }

  public Avatar(SkinTone skinTone,  BodyType bodyType) {
    this(skinTone, HairType.SHORT, HairColor.BLACK, bodyType, FacialFeatures.CLEAN_SHAVEN);
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

    var sb = new StringBuilder();
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
}
