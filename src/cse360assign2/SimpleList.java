/* Nicole Young
 * Class ID: 398
 * This assignment is designed to give practice with github
 * https://github.com/nicoleyoung1999/cse360assign2/blob/master/src/cse360assign2/SimpleList.java
 * username:nicoleyoung1999
 * password: 5t@yY0ung
 * Repository name: cse360assign2
 */

//test comment
//import needed packages

package cse360assign2;

/**
 * This class contains several methods: SimpleList that creates an array to hold
 * 10 integers and set count to 0, add which adds parameter to beginning of
 * list, remove which removes parameter from list, count which returns number of
 * elements stored in list, toString which returns list as a string, and search
 * which returns location of parameter in list.
 * 
 * Contained in the class are 2 variables used to define the list and count
 * 
 * @author nicoleyoung
 *
 */

public class SimpleList {
	private int[] list;
	private int count;

	/**
	 * Create an array to hold 10 integers and set count to 0
	 */

	public SimpleList() {
		super();
		// set length of array to 10
		list = new int[10];
		count = 0;
	}

	/**
	 * Add the parameter to the list at the beginning (index = 0). Integers in list
	 * are shifted to the right. If an element is added to a full list, last element
	 * "falls of"
	 * 
	 * @param parameter
	 */

	public void add(int parameter) {
		// if counter is equal to length of list, increase size of list by 50%
		if (count == list.length) {
			// determine size of new array, 50% larger than original array
			int newSize = (int) (list.length * 1.5);
			// create new array
			int[] newList = new int[newSize];
			// copy all elements from existing array to new array
			for (int index = 0; index < list.length; index++) {
				newList[index] = list[index];
			}
			// make list point to new array
			list = newList;
		}
		count++;
		// move other integers in the list
		for (int index = list.length - 1; index > 0; index--) {
			list[index] = list[index - 1];
		}
		// add the parameter to the list at index 0
		list[0] = parameter;
	}

	/**
	 * Find parameter in the list, then remove it. The other values in the list may
	 * need to be moved down. Adjust the count as needed.
	 * 
	 * @param foundInteger
	 *            The list cannot be reduced to less than 1 entry
	 */

	public void remove(int foundInteger) {
		// look for foundInteger in the array
		for (int index = 0; index < list.length; index++) {
			int value = list[index];
			if (value == foundInteger) {
				// match found. now remove value from list
				count--;
				// move down other values in list
				for (int newList = index; newList < list.length - 1; newList++) {
					list[newList] = list[newList + 1];
				}
				// determine utilization
				double utilization = 1.0 * count / list.length;
				if (utilization < 0.75) {
					// determine size of new array, 25% smaller than original array
					int newSize = (int) (list.length * .75);
					// size must be at least 1;
					if (newSize < 1) {
						newSize = 1;
					}
					// create new array
					int[] newList = new int[newSize];
					// copy all elements from existing array to new array
					for (int indexArray = 0; indexArray < newList.length; indexArray++) {
						newList[indexArray] = list[indexArray];
					}
					// make list point to new array
					list = newList;
				}
				// return; //if remove should only remove first occurence
				index--; // if remove should remove all occurences
			}
		}
	}

	/**
	 * Return the number of elements stored in the list.
	 * 
	 * @return
	 */

	public int count() {
		return count;
	}

	/**
	 * Return the list as a String. The elements must be separated by a space. This
	 * means there is not space after the last integer.
	 */

	public String toString() {
		// The elements are separated by a space
		String string = "";
		for (int index = 0; index < count; index++) {
			string += list[index];
			if (index < count - 1) {
				string += " ";
			}
		}
		return string; // string is returned
	}

	/**
	 * Return the location of the parameter in the list. If the parameter is not in
	 * the list, then return -1.
	 * 
	 * @param element
	 * @return
	 */

	public int search(int element) {
		// move down list scanning for searched element
		for (int index = 0; index < list.length; index++) {
			int newList = list[index];
			if (newList == element)
				return index;
		}
		return -1; // parameter is not in list
	}

	/**
	 * append the parameter to the end of the list. If the list was full, then
	 * increase the size by 50% so there will be room. Increment the count.
	 * 
	 * @param parameter
	 * @return parameter
	 */
	public void append(int parameterEnd) {
		// if counter is equal to length of list, increase size of list by 50%
		if (count == list.length) {
			// determine size of new array, 50% larger than original array
			int newSize = (int) (list.length * 1.5);
			// create new array
			int[] newList = new int[newSize];
			// copy all elements from existing array to new array
			for (int index = 0; index < list.length; index++) {
				newList[index] = list[index];
			}
			// make list point to new array
			list = newList;
		}

		// append parameter to end of list
		list[count] = parameterEnd;
		count++;

	}

	/**
	 * return the first element in the list
	 * if there are no elements in the list, return -1
	 * @return list
	 */

	public int first() {
		if (count == 0)
			return -1;
		return list[0];
	}

	/**
	 * Return the last element in the list.
	 * If there are no elements n the list, then return -1
	 * @return list
	 */

	public int last() {
		if (count == 0)
			return -1;
		return list[count - 1];
	}

	/**
	 * Return the current number of possible locations in the list
	 * @return count
	 */
	
	public int size() {
		return count;
	}
}
