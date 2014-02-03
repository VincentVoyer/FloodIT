/**
 * 
 */
package core;

/**
 * @author Vincent
 * @date 3 févr. 2014
 */
public class Point {
	
	private int i;
	
	private int j;

	public Point(int i, int j)
	{
		setI(i);
		setJ(j);
	}
	
	/**
	 * modify i.
	 * @param i the i to set
	 */
	private void setI(int i) {
		this.i = i;
	}

	/**
	 * modify j.
	 * @param j the j to set
	 */
	private void setJ(int j) {
		this.j = j;
	}

	/**
	 * Can get i.
	 * @return the i.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Can get j.
	 * @return the j.
	 */
	public int getJ() {
		return j;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
	
	
}
