import sa.edu.kau.fcit.cpit252.lab4BuilderFactory.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import static org.junit.jupiter.api.Assertions.*;

public class Lab4Test {


    // We should not have access to the constructor as it should be private
    @Test
    public void ShouldBePrivateConstructor() {
        for (Constructor c : Avatar.class.getConstructors()) {
            assertTrue(Modifier.isPrivate(c.getModifiers()));
        }
    }

    // Avatar should have one constructor with one parameter of Avatar.Builder type
    @Test
    public void constructorShouldTakeBuilderParameter() {
        assertEquals(1, Avatar.class.getDeclaredConstructors().length);
        assertEquals(1, Avatar.class.getDeclaredConstructors()[0].getParameterCount());
        assertEquals(Avatar.Builder.class, Avatar.class.getDeclaredConstructors()[0].getParameters()[0].getType());
    }

    // The Avatar class should have a private constructor with Builder parameter type
    @Test
    public void assertCorrectConstructorParameter() {
        boolean passed = false;
        for (Constructor c : Avatar.class.getDeclaredConstructors()) {
            assertEquals(1, c.getParameterCount());
            if (c.getParameterTypes()[0] == Avatar.Builder.class) {
                passed = true;
            }
        }
        assertTrue(passed);
    }

    // Should have an inner public static class called Builder
    @Test
    public void assertAvatarHasInnerClass() {
        assertEquals(1, Avatar.class.getDeclaredClasses().length);
        assertTrue(Modifier.isPublic(Avatar.class.getDeclaredClasses()[0].getModifiers()));
        assertTrue(Modifier.isStatic(Avatar.class.getDeclaredClasses()[0].getModifiers()));
    }

    // Should have a Builder class with setter methods
    @Test
    public void assertBuilderClassConstructor() {
        assertEquals(1, Avatar.Builder.class.getDeclaredConstructors().length);
        assertEquals(1, Avatar.Builder.class.getDeclaredConstructors()[0].getParameterCount());
        assertEquals(SkinTone.class, Avatar.Builder.class.getDeclaredConstructors()[0].getParameters()[0].getType());
    }

    // Should have a Builder class with setter methods that all return the Builder class type
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

    // Should have a Builder class with a build method that returns the Avatar class type
    @Test
    public void assertBuilderBuildMethod() {
        boolean passed = false;
        for (Method method : Avatar.Builder.class.getDeclaredMethods()) {
            if (method.getParameterCount() == 0 && method.getName().startsWith("build")) {
                assertEquals(0, method.getParameters().length);
                assertEquals(method.getReturnType().getTypeName(), Avatar.class.getName());
                passed = true;
            }
        }
        assertTrue(passed);
    }

    // Test build an avatar using method chaining
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
     * Test Factory Method
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

    // Factory method should not allow creating an avatar without a name
    @Test
    public void shouldNotCreateAnAvatarWithNoName() {
        assertThrows(IllegalArgumentException.class, () -> CharacterFactory.createCharacter(CharacterTypes.ARCHER, null));
    }
    
}
