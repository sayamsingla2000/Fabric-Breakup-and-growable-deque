// You should utilise your implementation of ArrayDeque methods to implement this
public class Stack implements StackInterface {	

    DequeInterface Deque = new ArrayDeque();

	public void push(Object o){
    	 Deque.insertLast(o);

    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  	}

	public Object pop() throws EmptyStackException{
    	
        if (size() == 0) throw new EmptyStackException("Stack is Empty");
        try {
            return Deque.removeLast();
        } catch (EmptyDequeException e) {
            e.printStackTrace();
        }
        return null;

    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public Object top() throws EmptyStackException{
    	if (size() == 0) throw new EmptyStackException("Stack is Empty");
        try {
            return Deque.last();
        } catch (EmptyDequeException e) {
            System.out.println("Stack is empty");
        }
        return null;
    	
        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public boolean isEmpty(){
    	return Deque.isEmpty();
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

    public int size(){
    	return Deque.size();
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}