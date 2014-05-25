package main;

class Priehradka implements Comparable<Priehradka> {

	final float value;
	int count;

	Priehradka(float value) {
		this.value = value;
	}

	Priehradka(float value, int count) {
		this.value = value;
		this.count = count;
	}

	/**
	 * 
	 * @param count accepts negative values
	 */
	public void addCash(int count) {
		this.count += count;
	}

	/**
	 * 
	 * @param needed value
	 * @return value that was available 
	 */
	public float getCash(float needed) {
		float remaining = needed;
		float result = 0;  //can be substitued with "return" object that holds value and count of returned coins (if you need to control how many coins can be returned total) 
		while (remaining >= this.value && count > 0) {
			remaining -= this.value;
			result += this.value;
			count--;
		}
		return result;
	}

	public float getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return Float.hashCode(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Priehradka) {
			return this.value == ((Priehradka) o).value;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Priehradka arg0) {
		return Float.compare(this.value, arg0.value);
	}
}
