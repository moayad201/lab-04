import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Lab4Test {

    /*
     * Test the Builder Design Pattern
     */

    // Avatar constructor: should have one private constructor with one parameter of Avatar.Builder type
    // TODO: replace getDeclaredConstructors() as it seems to be unpredictable when working with nested classes
    @Test
    public void assertCorrectConstructorParameter() {
        boolean passed = false;
        assertEquals(0, Avatar.class.getConstructors().length);
        for (Constructor c : Avatar.class.getDeclaredConstructors()) {
            if (c.getParameterCount() == 1 && c.getParameterTypes()[0] == Avatar.Builder.class && Modifier.isPrivate(c.getModifiers())) {
                passed = true;
            }
        }
        assertTrue(passed);
    }

    // Avatar class should have a nested public static class called Builder
    @Test
    public void assertAvatarHasInnerClass() {
        assertEquals(1, Avatar.class.getDeclaredClasses().length);
        assertTrue(Modifier.isPublic(Avatar.class.getDeclaredClasses()[0].getModifiers()));
        assertTrue(Modifier.isStatic(Avatar.class.getDeclaredClasses()[0].getModifiers()));
        assertEquals(Avatar.class.getDeclaredClasses()[0].getName(), Avatar.Builder.class.getName());
    }

    // Avatar.Builder class should have a set of setter methods whose name start with "with",
    // takes one parameter, and returns Avatar.Builder class type
    @Test
    public void assertBuilderSetterMethods() {
        boolean passed = false;
        for (Method method : Avatar.Builder.class.getDeclaredMethods()) {
            if (method.getParameterCount() == 1 && method.getName().startsWith("with")) {
                assertEquals(1, method.getParameters().length);
                assertEquals(method.getReturnType().getTypeName(), Avatar.Builder.class.getName());
                passed = true;
            }
        }
        assertTrue(passed);
    }

    //  Avatar.Builder class should have a Builder class with a build method called build that returns the Avatar class type and takes no parameters
    @Test
    public void assertBuilderBuildMethod() {
        boolean passed = false;
        for (Method method : Avatar.Builder.class.getDeclaredMethods()) {
            if (method.getParameterCount() == 0 && method.getName().equalsIgnoreCase("build")) {
                assertEquals(0, method.getParameters().length);
                assertEquals(method.getReturnType().getTypeName(), Avatar.class.getName());
                passed = true;
            }
        }
        assertTrue(passed);
    }

    // Should build an avatar using method chaining
    @Test
    public void testBuildAnAvatar() {
        final Avatar avatar = new Avatar.Builder(SkinTone.FAIR)
                .withBodyType(BodyType.FIT)
                .withFacialFeatures(FacialFeatures.CLEAN_SHAVEN)
                .withHairType(HairType.LONG_CURLY)
                .withHairColor(HairColor.BLOND)
                .build();
        assertNotNull(avatar);
        assertNotNull(avatar.toString());
        assertEquals(SkinTone.FAIR, avatar.getSkinTone());
        assertEquals(BodyType.FIT, avatar.getBodyType());
        assertEquals(FacialFeatures.CLEAN_SHAVEN, avatar.getFacialFeatures());
        assertEquals(HairType.LONG_CURLY, avatar.getHairType());
        assertEquals(HairColor.BLOND, avatar.getHairColor());
    }


    /*
     * Test the Factory Method Design Pattern
     */


    // Factory method should take two parameters (CharacterType and String) and returns a Character
    @Test
    public void shouldHaveAFactoryMethodWithCorrectParameters() {
        boolean passed = false;
        for (Method method : CharacterFactory.class.getDeclaredMethods()) {
            if (method.getParameterCount() == 2 && method.getName().equalsIgnoreCase("createCharacter")) {
                assertEquals(2, method.getParameters().length);
                assertEquals(method.getParameters()[0].getType().getTypeName(), CharacterTypes.class.getTypeName());
                assertEquals(method.getParameters()[1].getType().getTypeName(), String.class.getTypeName());
                assertEquals(method.getReturnType().getTypeName(), Characters.class.getName());
                passed = true;
            }
        }
        assertTrue(passed);
    }

    // Factory method should return an avatar for the given character type and name
    @Test
    public void shouldCreateAnAvatarInTheFactoryMethod() {
        assertNotNull(CharacterFactory.createCharacter(CharacterTypes.ARCHER, "coolArcher"));
        assertNotNull(CharacterFactory.createCharacter(CharacterTypes.ARCHER, "coolArcher").getAvatar());
    }

    // Factory method should not create an avatar without a name and should throw an IllegalArgumentException
    @Test
    public void shouldNotCreateAnAvatarWithNoName() {
        assertThrows(IllegalArgumentException.class, () -> CharacterFactory.createCharacter(CharacterTypes.ARCHER, null));
    }

}
