import java.util.*;


public class MaxArea {
   public static void main(String[] args) {
    int max = 0;
    int[] intArray={6,2,5,4,5,1,6};
    int[] result = new int[intArray.length];

    int[] nsl = NSL(intArray);
    int[] nsr = NSR(intArray);

    for(int i=0; i<intArray.length;i++){
        result[i] =(nsr[i]-nsl[i]-1)*intArray[i];
        if(result[i]>max){
            max = result[i];
        }
    }
    System.out.println(Arrays.toString(nsr));
    System.out.println(Arrays.toString(nsl));
    System.out.println(max);
       
   } 

   public static int[] NSL(int[] arr){
       //NSL -1 boundary
    int[] res = new int[arr.length];
     Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){

            if(st.isEmpty()){
                res[i] = -1;
            }

            else if(!st.empty() && arr[i]>arr[st.peek()]){
                res[i] =st.peek();
            }
            else if(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()){
                res[i]= st.peek();
                }
                else{
                    res[i] = -1;
                    
                }
            }
            st.push(i);

        }            
        

    return res;    
   }

   public static int[] NSR(int[] arr){
       //NSR array.length boundary
       int[] res = new int[arr.length];
       Stack<Integer> st = new Stack<>();
      for(int i=arr.length-1;i>=0;i--){
              if(st.isEmpty()){
                  res[i] = arr.length;
                  st.push(i);
              }
  
              else if(!st.empty() && arr[i]>arr[st.peek()]){
                  res[i] = st.peek();
              }
              else if(!st.empty() && arr[i]<=arr[st.peek()]){    
                  while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                      st.pop();
                  }
                  if(!st.empty()){
                  res[i]= st.peek();
                  }
                  else{
                      res[i] = arr.length;

                  }
          }      
                st.push(i);
          }            
  
      return res; 
   }
}

 