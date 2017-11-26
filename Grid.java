import java.util.Random;

public class Grid {
	private Snake snake;
	private Node food;
	public final boolean status[][];
	private final int width;
	private final int height;
	private Direction snakeDirection = Direction.LEFT;
	
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		status = new boolean[width][height];

		snake = initSnake();
		food = createFood();
	}
	
	private Snake initSnake(){
		snake = new Snake();
		for(int i = 0; i<10;i++){
			snake.addTail(new Node(width/2+i,height/2));
			status[width/2+i][height/2] = true;
		}
		return snake;
	}
	
	private Node createFood(){
		int x,y;
		Random random = new Random();
		x = random.nextInt(width-1);
		y = random.nextInt(height-1);
//		while(status[x][y]){
//			x = random.nextInt(width);
//			y = random.nextInt(height);
//		}
		Node food = new Node(x,y);
		System.out.println(Integer.toString(food.getX()) + Integer.toString(food.getY()));
		return food;
	}
	public boolean nextRound(){
		System.out.println("2");
		Node nextMove = snake.move(snakeDirection);
		
		if(isBoundary(snake.getHead())){
			return false;
		}
		else{
			if(isBody()){
				return false;
			}
			else if(isFood(food)){
					System.out.println("???");
					snake.addTail(nextMove);
					food = createFood();
				}
			else{
					status[snake.getHead().getX()][snake.getHead().getY()] = true;
					status[nextMove.getX()][nextMove.getY()] = false;
				}
			return true;
		}

		
	}
	private boolean isFood(Node n){
		int headX = snake.getHead().getX();
		int headY = snake.getHead().getY();
		int x = n.getX();
		int y = n.getY();
		if(headX == x && snakeDirection == Direction.LEFT && headY == y){
			return true;
		}
		else if(x == headX && snakeDirection == Direction.RIGHT && headY == y){
			return true;
		}
		else if(headY == y && snakeDirection == Direction.DOWN && headX == x){
			return true;
		}
		else if(y == headY && snakeDirection == Direction.UP && headX == x){
			return true;
		}
		else{return false;}
	}
	
	private boolean isBoundary(Node n){
		int x = n.getX();
		int y = n.getY();
		if(x == -1 && snakeDirection == Direction.LEFT){
			return true;
		}
		else if(x == width && snakeDirection == Direction.RIGHT){
			return true;
		}
		else if(y == height && snakeDirection == Direction.DOWN){
			return true;
		}
		else if(y == -1 && snakeDirection == Direction.UP){
			return true;
		}
		else{return false;}
	}
	private boolean isBody(){
		int headX = snake.getHead().getX();
		int headY = snake.getHead().getY();
		if(status[headX][headY] && snakeDirection == Direction.LEFT){
			return true;
		}
		else if(status[headX][headY] && snakeDirection == Direction.RIGHT ){
			return true;
		}
		else if(status[headX][headY] && snakeDirection == Direction.DOWN ){
			return true;
		}
		else if(status[headX][headY] && snakeDirection == Direction.UP){
			return true;
		}
		else{return false;}
	}
	
	public void changeDirection(Direction newDirection) {
	    if (snakeDirection.compatibleWith(newDirection)) {
	        snakeDirection = newDirection;
	    }
	}

	public Node getFood() {
		return food;
	}

	public Snake getSnake() {
		return snake;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
