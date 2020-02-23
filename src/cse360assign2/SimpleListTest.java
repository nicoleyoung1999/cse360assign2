

/* Nicole Young
 * Class ID: 398
 * This assignment is designed to give practice with Javadoc, creating unit tests and using Junit
 */


//import needed packages
package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

//Do I need a failing test case?
//	@Test
//	void testFail() {
//		fail("Test Fail");
//	}
	
	//test that method returns number of elements stored in list
	@Test
	void testCount0() {
		SimpleList list = new SimpleList();
		assertEquals(0, list.count());
	}
	

	@Test
	void testCount1() {
		SimpleList list = new SimpleList();
		list.add(2);
		//the list should store amount inputed using method
		assertEquals(1, list.count()); 
	}
	
	//check array can hold 10 integers 
	//Add, Count, Simple List method is all checked
	@Test
	void testCountWithTenAdds() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		assertEquals(10, list.count());
	}
	
	//check what happens when Simple List has 11 adds
	//last element should "fall off" list
	@Test
	void testCountWithElevenAdds() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		//now stores all 11 elements in array
		assertEquals(11, list.count()); 
	}
	
	//toString method returns list as string
	//checks when array has nothing stored in list
	@Test
	void testToStringWithNoElements() {
		SimpleList list = new SimpleList();
		assertEquals("", list.toString());
	}
	
	//toString method returns list as string
	//checks when array has one element stored in list
	@Test
	void testToStringWithOneElement() {
		SimpleList list = new SimpleList();
		//add method is used to add element into list
		list.add(2); 
		assertEquals("2", list.toString());
	}
	
	//toString method returns list as string
	//checks when array has more than one element stored in list
	@Test
	void testToStringWithTwoElements() {
		SimpleList list = new SimpleList();
		list.add(2); //add method used to add elements
		list.add(4);
		assertEquals("4 2", list.toString());
	}
	
	//toString method returns list as string
	//checks when array has more than one element stored in list
	@Test
	void testToStringWithThreeElements() {
		SimpleList list = new SimpleList();
		list.add(2);
		list.add(4);
		list.add(6);
		assertEquals("6 4 2", list.toString());
	}
	
	//toString method returns list as string
	//checks when array has 10 elements stored in list
	@Test
	void testToStringWithTenElements() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		assertEquals("10 9 8 7 6 5 4 3 2 1", list.toString());
	}
	
	//toString method returns list as string
	//checks when array has 11 elements added in list
	//list can only hold 10 elements
	@Test
	void testToStringWithElevenAdds() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		//keep all elements 
		assertEquals("11 10 9 8 7 6 5 4 3 2 1", list.toString()); 
		assertEquals(11, list.first());
		assertEquals(1, list.last());
	}
	
	//Add the parameter to the list at the beginning
	//checks array can hold more than one of the same element
	@Test
	void testAddWithDuplicateElements() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		assertEquals("10 9 8 7 6 3 3 3 2 1", list.toString());
	}
	
	//If the parameter is in the list, then remove it
	//remove duplicate elements in list
	@Test
	void testRemoveWithDuplicateElements() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.remove(3);
		assertEquals("10 9 8 7 6 2 1", list.toString());
	}
	
	//If the parameter is in the list, then remove it
	//if element is not in list, ignore
	@Test
	void testRemoveOfNonexistantElement() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.remove(11);
		assertEquals("10 9 8 7 6 5 4 3 2 1", list.toString());
	}
	
	//Return the location of the parameter in the list
	@Test
	void testSearchWithElement() {
		SimpleList list = new SimpleList();
		list.add(2);
		list.add(4);
		list.add(6);
		assertEquals(1, list.search(4));
	}
	
	//Return the location of the parameter in the list
	@Test
	void testSearchWithoutElement() {
		SimpleList list = new SimpleList();
		list.add(2);
		list.add(4);
		list.add(6);
		//If the parameter is not in the list, then return -1
		assertEquals(-1, list.search(8)); 
	}
}

