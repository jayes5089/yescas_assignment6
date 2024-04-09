package a6;
/* Jason Yescas
   Object-Oriented Programming : CPSC-24500-001
   4/8/2024
   ThreeDNode Class */

public class ThreeDNode extends Node {
	private int z;
	
	// Default constructor, initializes the node to (0,0,0)
	public ThreeDNode() throws Exception {
		super(); // Call to superclass constructor for x and y
		this.z = 0;
	}
	
	/**
	 * Constructs a ThreeDNode with x,y,z coordinates
	 * @param x
	 * @param y
	 * @param z
	 * @throws Exception if any coordinate is out of the range
	 */
	public ThreeDNode(int x, int y, int z) throws Exception {
		super(x, y); // Call to superclass constructor for x and y
		setZ(z); // sets Z
	}
	
	/**
	 *  Copy constructor
	 * @param other
	 * @throws Exception
	 */
	public ThreeDNode(ThreeDNode other) throws Exception {
		super(other.getX(), other.getY()); // Call to superclass constructor with copied coordinates
		this.z = other.getZ(); // copy z-coordinate
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) throws Exception {
		if (!isValidZ(z)) throw new Exception("Invalid Z value");
		this.z = z;
	}
	
	private boolean isValidZ(int z) {
		return z >= LOWER_LIMIT && z <= UPPER_LIMIT;
	}
	
	@Override
	public void add(Node node) throws Exception {
		super.add(node);
		if (node instanceof ThreeDNode) {
			ThreeDNode threeDNode = (ThreeDNode) node;
			int newZ = this.z + threeDNode.getZ();
			if (!isValidZ(newZ)) throw new Exception("Resulting Z is out of bounds");
			this.z = newZ; // Add z-coordinate
		}
	}
	
	@Override
	public String toString() {
		return super.toString().replace(")",","+ z +")");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ThreeDNode) {
			ThreeDNode other = (ThreeDNode) obj;
			return super.equals(other) && this.z == other.getZ();
		}
		return false;
	}
}
