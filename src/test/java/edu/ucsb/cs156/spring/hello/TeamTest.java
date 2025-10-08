package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_SameObject() {
        Team t1 = new Team();
        assertEquals(true, t1.equals(t1));
    }

    @Test
    public void equals_returns_correct_DifferentClass() {
        Team t1 = new Team();
        assertEquals(false, t1.equals(1));
    }

    @Test
    public void equals_returns_correct_NameAndMembersTT() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(true, t1.equals(t2));
        assertEquals(true, t2.equals(t1));
    }

    @Test
    public void equals_returns_correct_NameAndMembersTF() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("dsafa");
        assertEquals(false, t1.equals(t2));
        assertEquals(false, t2.equals(t1));
    }
    @Test
    public void equals_returns_correct_NameAndMembersFT() {
        Team t1 = new Team();
        t1.setName("dfsasdfsadfv");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(false, t1.equals(t2));
        assertEquals(false, t2.equals(t1));    }
    @Test
    public void equals_returns_correct_NameAndMembersFF() {
        Team t1 = new Team();
        t1.setName("dfsasdfa");
        t1.addMember("dfdf");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(false, t1.equals(t2));
        assertEquals(false, t2.equals(t1));
    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
