
public enum Direction {
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	private final int directionCode;

	Direction(int dc){
		directionCode = dc;
	}
	
	public int directionCode() {
        return directionCode;
    }

	public boolean compatibleWith(Direction newDirection) {
		if(Math.abs(this.ordinal() - newDirection.ordinal()) !=2 ){
			return true;
		}
		return false;
	}
}
