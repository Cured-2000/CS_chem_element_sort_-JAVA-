
public class Element {
	private String name;
	private int atomicNumber;
	private double atomicWieght;

	public Element(String name, int atomicNumber, double atomicWieght) {
		this.name = name;
		this.atomicNumber = atomicNumber;
		this.atomicWieght = atomicWieght;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public double getAtomicWieght() {
		return atomicWieght;
	}

	public void setAtomicWieght(double atomicWieght) {
		this.atomicWieght = atomicWieght;
	}

	@Override
	public String toString() {
		if (this.name.length() < 8) {
			return name + "		" + atomicNumber + "	" + atomicWieght + "\n";
		}
		return name + "	" + atomicNumber + "	" + atomicWieght + "\n";

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (atomicNumber != other.atomicNumber)
			return false;
		if (Double.doubleToLongBits(atomicWieght) != Double.doubleToLongBits(other.atomicWieght))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
