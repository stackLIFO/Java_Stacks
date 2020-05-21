import java.util.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
        String str = scan.next();
        Stack<Character> st = new Stack<>();
        String res  = "";

        for(int i=0;i<str.length();i++){
            if(st.isEmpty()){
                res = res+"A";
                st.push(str.charAt(i));
            }

            else if(!st.empty() && str.charAt(i)<st.peek()){
                res=res+st.peek();
                st.push(str.charAt(i));
            }
            else if(!st.empty() && str.charAt(i)>=st.peek()){
                while(!st.isEmpty() && str.charAt(i)>=st.peek()){
                    st.pop();
                }
                if(!st.empty()){
                res=res+st.peek();
                st.push(str.charAt(i));
                }
                else{
                    res = res+ "A";
                }
            }

        }            
        
        System.out.println(res);

    }
}
}