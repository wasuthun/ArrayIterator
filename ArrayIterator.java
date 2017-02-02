
import java.util.Iterator;

import java.util.NoSuchElementException;



/**

  service to repeat through elements in an array without knowing the structure in array.

 * @author Wasuthun wanaphongthipakorn

 * @param <T>

 */

public class ArrayIterator<T> implements Iterator<T> {

	// if this ArrayIterator can call .remove() 

	private boolean Valid;

	// index of the next element to return 

	private int dart;

	// attribute of the array we want to repeat over 

	private T[] array;



	/**

	 *Start a new array repeat with the array to operate.

	 * 

	 * @param array

	 */

	public ArrayIterator(T[] array) {

		this.array = array;

		this.Valid = false;

		// TODO: initialize any other variables you need

	}



	/**

	 * Return the next non-null element from array.

	 * @return the next non-null element in the array.

	 * @throws NoSuchElementException

	 */

	@Override

	public T next() {

		if (this.hasNext()) {

			T next = array[dart];

			this.dart++;

			this.Valid = true;

			return next;

		} else

			throw new NoSuchElementException();

	}



	/**

	 * Return {@code true} if the repetition has more non-null elements.

	 * 

	 * @return {@code true} if the repetition has more non-null elements,

	 *         {@code false} opposite

	 */

	@Override

	public boolean hasNext() {

		for (int j = this.dart; j < this.array.length; j++) {

			if (this.array[j] != null) {

				dart = j;

				return true;

			}

		}

		return false;

	}



	/**

	 * Remove final element returned form ArrayIterator. This method commit

	 * labeled only once per call to {@link #next}.

	 * 

	 * @throws IllegalStateException

	 *             if the {@code next} method has not yet been labeled, or the

	 *             {@code remove} method has already been labeled after the last

	 *             call to the {@code next} method

	 */

	@Override

	public void remove() {

		if (Valid) {

			array[dart - 1] = null;

			Valid = false;

		} else

			throw new IllegalStateException();

	}



}