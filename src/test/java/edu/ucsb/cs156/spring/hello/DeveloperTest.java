package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Dalia S.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("dalidog", Developer.getGithubId());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-08", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("DALIA"),"Team should contain Dalia S.");
        assertTrue(t.getMembers().contains("KRYSTELLE CAPILI"),"Team should contain Krystelle B.");
        assertTrue(t.getMembers().contains("LUCY"),"Team should contain Lucy D.");
        assertTrue(t.getMembers().contains("SRIYA"),"Team should contain Sriya V.");
        assertTrue(t.getMembers().contains("VARSHA"),"Team should contain Varsha N.");
        assertTrue(t.getMembers().contains("EMILY"),"Team should contain Emily L.");
    }

}
