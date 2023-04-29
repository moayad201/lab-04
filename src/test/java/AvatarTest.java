



import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.Avatar;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.BodyType;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.CharacterFactory;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.CharacterTypes;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.FacialFeatures;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.HairColor;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.HairType;
import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.SkinTone;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AvatarTest {


  @Test
  void testMissingName() {
    assertThrows(IllegalArgumentException.class, () -> CharacterFactory.createCharacter(CharacterTypes.ARCHER, null));
  }


  @Test
  void testMissingSkin() {
    assertThrows(IllegalArgumentException.class, () -> new Avatar.Builder(null));
  }

  @Test
  void testBuildHero() {
    final var hero = new Avatar.Builder(SkinTone.FAIR)
        .withBodyType(BodyType.FIT)
        .withFacialFeatures(FacialFeatures.CLEAN_SHAVEN)
        .withHairType(HairType.LONG_CURLY)
        .withHairColor(HairColor.BLOND)
        .build();

    assertNotNull(hero);
    assertNotNull(hero.toString());
    assertEquals(SkinTone.FAIR, hero.getSkinTone());
    assertEquals(BodyType.FIT, hero.getBodyType());
    assertEquals(FacialFeatures.CLEAN_SHAVEN, hero.getFacialFeatures());
    assertEquals(HairType.LONG_CURLY, hero.getHairType());
    assertEquals(HairColor.BLOND, hero.getHairColor());

  }

}