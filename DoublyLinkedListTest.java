import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void testDoublyLinkedList() {
		DoublyLinkedList<Integer> Dll = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Dll = new DoublyLinkedList<Integer>();
		//TEST FOR WHEN EMPTY
		assertTrue("", Dll.isEmpty());
		//TEST FOR WHEN SINGLE ELEMENT
		Integer data = 1; 
		Dll.push(data);
		assertFalse("", Dll.isEmpty());
		//TEST FOR WHEN MULTIPLE ELEMENTS
		data = 2;
		Dll.push(data);
		assertFalse("", Dll.isEmpty());
	}

	@Test
	public void testInsertBefore() {
		Dll = new DoublyLinkedList<Integer>();
		//TEST FOR WHEN LIST IS EMPTY
			//INDEX WITHIN BOUNDS
		int pos = 0;
		Integer data = 1;
		Dll.insertBefore(pos, data);
			//INDEX OUT OF BOUNDS
		Dll = new DoublyLinkedList<Integer>();
		pos = -5;
		data = 1;
		Dll.insertBefore(pos, data);
	
		//TEST FOR WHEN SINGLE ELEMENT
			//INDEX WITHIN BOUNDS
		pos = 0;
		data = 2;
		Dll.insertBefore(pos, data);
		assertEquals(data, Dll.get(0) );
			//INDEX OUT OF BOUNDS
		Dll = new DoublyLinkedList<Integer>();
		Dll.insertBefore(0 , 1);
		pos = 5;
		data = 2;
		Dll.insertBefore(pos, data);
		assertEquals(data, Dll.get(1) );
		
		//TEST FOR WHEN MULTIPLE ELEMENTS
			//INDEX WITHIN BOUNDS
		pos = 2;
		data = 3;
		Dll.insertBefore(pos, data);
		assertEquals(data, Dll.get(2));
			//INDEX OUT OF BOUNDS
		pos = 10;
		data = 4;
		Dll.insertBefore(pos,data);
		assertEquals(data, Dll.get(3));
	}

	@Test
	public void testGet() {
		DoublyLinkedList Dll = new DoublyLinkedList<Integer>();
		int pos;
		Integer expectedValue;
		//TEST FOR WHEN EMPTY
		pos = 0;
		expectedValue == null;
		assertEquals(expectedValue, Dll.get(0));

		//TEST FOR WHEN SINGLE ELEMENT
		expectedValue = 1;
		Dll.insertBefore(0, expectedValue);
			//INDEX WITHIN BOUNDS
		pos = 0;
		assertEquals(expectedValue, Dll.get(pos));
			//INDEX OUT OF BOUNDS
		pos = -1;
		expectedValue = null;
		assertEquals(expectedValue, Dll.get(pos));

		//TEST FOR WHEN MULTIPLE ELEMENTS
		expectedValue = 2;
		Dll.insertBefore(1, expectedValue);
			//INDEX WITHIN BOUNDS
		pos = 1;
		assertEquals(expectedValue, Dll.get(pos));
			//INDEX OUT OF BOUNDS
		pos = 10;
		expectedValue = null;
		assertEquals(expectedValue, Dll.get(pos));
	}

	/**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     */
	@Test
	public void testDeleteAt() {
		DoublyLinkedList Dll = new DoublyLinkedList<Integer>();
		int pos;
		boolean expectedValue;
		//TEST WHEN EMPTY	
			//INDEX WITHIN BOUNDS
			
		
			//INDEX OUT OF BOUNDS

		//TEST WHEN SINGLE ELEMENT
			//INDEX WITHIN BOUNDS
			//INDEX OUT OF BOUNDS

		//TEST WHEN MULTIPLE
			//INDEX WITHIN BOUNDS
			//INDEX OUT OF BOUNDS

	}

	@Test
	public void testReverse() {
		
	}

	@Test
	public void testPush() {
		Dll = new DoublyLinkedList<Integer>();
		Integer data = 1;
		
		//TEST WHEN EMPTY
		Dll.push(data);
		assertEquals(data, get(0));
		
		//TEST WHEN SINGLE ELEMENT
		data = 2;
		Dll.push(data);
		assertEquals(data, get(1));
		
		//TEST WHEN MULTIPLE ELEMENTS
		data = 2;
		Dll.push(data);
		assertEquals(data, get(2));
	}
	
	@Test
	public void testPop() {
		Dll = new DoublyLinkedList<Integer>();
		
		Integer expectedValue;
		//TEST WHEN EMPTY
		expectedValue = null;
		assertEquals(expectedValue, Dll.pop());
		
		//TEST WHEN SINGLE ELEMENT
		Integer data = 1;
		Dll.push(data);
		expectedValue = data;
		asserEquals(expectedValue, Dll.pop());
		
		//TEST WHEN MULTIPLE ELEMENTS
		data = 1;
		Dll.push(data);
		data = 2;
		Dll.push(data);
		expectedValue = data
		assertEquals(expectedValue, Dll.pop());
	}

	@Test
	public void testEnqueue() {
		//TEST WHEN EMPTY
		
		//TEST WHEN SINGLE ELEMENT
		
		//TEST WHEN MULTIPLE ELEMENTS

	}

	@Test
	public void testDequeue() {
		//TEST WHEN EMPTY
		
		//TEST WHEN SINGLE ELEMENT
		
		//TEST WHEN MULTIPLE ELEMENTS

	}

	@Test
	public void testToString() {

	}
	
	public static void main(){}

}
