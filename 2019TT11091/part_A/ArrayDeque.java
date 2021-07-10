public class ArrayDeque implements DequeInterface {

	 private Object[] data;
    private int head;
    private int tail;
    private int capacity;
    private static final int CAPACITY = 1;

    public ArrayDeque(){
        data =  new Object[1];
        head = 0 ;
        tail= 0;
        capacity = CAPACITY;
    }

     private void doubleCapacity(){

        capacity = (capacity * 2);
        Object[] new_array = new Object[capacity];

         int newHead = (capacity -size()) / 2;
         int  t = 0;
         for(int i = head ; i<tail; i++){
             new_array[newHead] = data[i];
                    newHead++;
                t++;}

         head=(capacity-size()) / 2;
         tail = newHead;
         data = new_array;
         capacity = capacity;
     }


   public void insertFirst(Object o){

       if(isEmpty()){
            data[head] = o;
            tail++;}
       else {
           //when head = 0 it is doubly its size
           while(head <= 0)
               doubleCapacity();

           if(!isEmpty())
               head--;
               data[head] = o;
       }

        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
  
   public void insertLast(Object o) {
        //you need to implement this

         if(tail == capacity)
            doubleCapacity();

        data[tail] = o;
        tail++;

        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

  
  public Object removeFirst() throws EmptyDequeException{
       
        if(isEmpty()) throw new EmptyDequeException("it is already empty");
        Object answer = data[head];
        data[head] = null;
        head++;

        if(head == tail) {
            head = 0;
            tail = 0;
        }
        return answer;
        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
  
  public Object removeLast() throws EmptyDequeException{
        if(isEmpty()) throw new EmptyDequeException("it is already empty");
        tail--;
        Object answer = data[tail];
        data[tail] = null;

        return answer;

       // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

   public Object first() throws EmptyDequeException{
        if(size() == 0) throw new EmptyDequeException("it is empty");
        return data[head];
       // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
  
  public Object last() throws EmptyDequeException{
        if(size() == 0) throw new EmptyDequeException("it is empty");
        tail--;
        Object answer = data[tail];
        tail++;
        return answer;
        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
  
  public int size(){
        return tail-head;
        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

  public boolean isEmpty(){
        return head==tail;
        //  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

  public String toString(){
        String output = "[";
        if (tail>0){
            output = output+ data[head];
            for(int i=(head+1); i<tail; i++ ){
                output = output + ", " + data[i];
            }
        }
        //output = output + "]";
        return output + "]";
        //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}