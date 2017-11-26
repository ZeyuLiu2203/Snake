import java.util.Iterator;
import java.util.LinkedList;

public class Snake implements Iterable<Node>{
	private LinkedList<Node> body = new LinkedList<>();
	
	public Node eat(Node food){
		//if food is next to head, then add it into body, return food
		
		if(isNeighbor(getHead(),food)){
			body.addFirst(food);
			return food;
		}
		//otherwise return null;
		else{return null;}
	}
	
	public Node move(Direction d){
		if(d == Direction.UP){
			body.addFirst(new Node(getHead().getX(),getHead().getY()-1));
		}
		else if(d == Direction.RIGHT){
			body.addFirst(new Node(getHead().getX()+1,getHead().getY()));
		}
		else if(d == Direction.DOWN){
			body.addFirst(new Node(getHead().getX(),getHead().getY()+1));
		}
		else if(d == Direction.LEFT){
			body.addFirst(new Node(getHead().getX()-1,getHead().getY()));
		}
		
		return body.pollLast();
		
	}
	public Node getHead(){
		return body.getFirst();
	}
	public void addTail(Node n){
		body.addLast(n);
	}
	
	private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }

	public LinkedList<Node> getBody() {
		return body;
	}

	@Override
	public Iterator<Node> iterator() {
		
		return body.iterator();
	}

	
}
