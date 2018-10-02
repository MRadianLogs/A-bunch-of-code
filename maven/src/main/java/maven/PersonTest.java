package maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * This is the PersonTest class. It is testing the methods and variables of the Person class. The purpose of this 
 * class is to become familiar with Maven. 
 *
 * @author Michael Jesus Reyes
 *
 */
class PersonTest
{
	Person person1;
	Person person2;
	
	@BeforeAll
	static void start()
	{
		System.out.println("Starting Test");
	}
	
	@BeforeEach
	void setUp()
	{
		person1=new Person("Joe","Smith",22);
		person2=new Person("John","Smith",21);
	}
	
	@AfterEach
	void tearDown()
	{
		person1=null;
		person2=null;
	}
	
	@AfterAll
	static void stop()
	{
		System.out.println("End Testing");
	}
	
	@Test
	void test1_CheckP1LastName()
	{
		assertEquals("Joe", person1.getLastName());
	}
	
	@Test
	void test2_CheckP2LastName()
	{
		assertEquals("Smith", person2.getLastName());
	}

	@Test
	void test3_CompareAge()
	{
		assertFalse(person1.getAge() < person2.getAge());
	}
	
	@Test
	void test4_CheckP1Null()
	{
		assertNull(person1);
	}
	
	@Test
	void test5_CheckP2NotNull()
	{
		assertNotNull(person2);
	}
	
	@Test
	void test6_CheckP1LastNameTrue()
	{
		assertTrue(person2.getLastName().equals("Smith"));
	}
}
