import java.io.*;
import java.util.Scanner;
public class FabricBreakup {	
	public static void main(String args[]){
		// Implement FabricBreakup puzzle using Stack interface
		 try {
            // FileInputStream txtFile = new FileInputStream(args[0]);
            File file1 = new File(args[0]);
            Scanner s = new Scanner(file1);

            int N = s.nextInt();

            StackInterface myStack = new Stack();
            StackInterface maxStack = new Stack();
            int[][] a = new int[N][3];
            int out = -1;
            int m = 0;
            int max = 0;


            for (int i = 0; i < N; i++) {
                a[i][0] = s.nextInt();
                //System.out.println(a[i][0]);
                a[i][1] = s.nextInt();
               // System.out.println("-" + a[i][1]);
                if (a[i][1] == 1) {
                    a[i][2] = s.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {

                if (a[i][1] == 1) {
                    m = a[i][2];
                    max = m;
                    if(!maxStack.isEmpty() && max < (Integer) maxStack.top()){
                        max = (Integer) maxStack.top();
                    }
                    myStack.push(m);
                    maxStack.push(max);
                }
                else if (a[i][1] == 2) {
                    int j = i + 1;
                    if (myStack.isEmpty()) {
                        out = -1;
                        System.out.println(j + " " + out);
                    }
                    else if (myStack.size() == 1) {
                        out = 0;
                        myStack.pop();
                        maxStack.pop();
                        System.out.println(j + " " + out);
                    }
                    else {
                        out = 0;
                        int p = (Integer)myStack.pop();
                        maxStack.pop();
                        //while (p < (Integer)myStack.top()) {
                        while (p < (Integer) maxStack.top()) {
                                p = (Integer) myStack.pop();
                                maxStack.pop();
                                out++;

                                if(myStack.isEmpty()){
                                    break;
                                }
                            }
                            System.out.println(j + " " + out);
                        }
                    }
            }
        } catch(EmptyStackException | FileNotFoundException e){
                e.printStackTrace();


        }
	}
}
