package SampleAbspielen;

import java.util.Vector;

/**
 * Startet ein Sample
 * @author Emanuel
 * @version 0.1
 */

public class SampleStarten {
	
Vector<SampleAbspielen> sampleAbspielen;
	
	/**
	 * Startet das Sample
	 * @author Emanuel
	 */

	public SampleStarten(){
		
		this.sampleAbspielen = new Vector<SampleAbspielen>();
		
		
	}
	
	/**
	 * Gibt das letzte Element des Vektors {@link sampleAbspielen}
	 * @author Emanuel
	 * @return {@link SampleAbspielen}
	 */
	
	public SampleAbspielen lastElement() {
		return sampleAbspielen.lastElement();
	}

	/**
	 * Gibt den index eines Elements des Vektors {@link sampleAbspielen}
	 * @author Emanuel
	 * @param Object o
	 * @return {@link Integer}
	 */
	
	public int indexOf(Object o) {
		return sampleAbspielen.indexOf(o);
	}

	/**
	 * Löscht ein Element des Vektors {@link sampleAbspielen}
	 * @author Emanuel
	 * @param Object o
	 * @return {@link Boolean}
	 */
	
	public boolean removeSoundAbspielens(Object o) {
		return sampleAbspielen.remove(o);
	}
	
	/**
	 * Startet ein Sample
	 * @author Emanuel
	 * @param {@link Integer} taste
	 */
	
	public void spieleSampleton(int taste) {

		System.gc();

		sampleAbspielen.add(new SampleAbspielen());
		sampleAbspielen.lastElement().clapAbspielen();
		
	}

}
