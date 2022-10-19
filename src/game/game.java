
package game;
public class game {   
    public static byte  method(byte arr[][]){
   
      
        if(arr[1][1]!=0)
        {
            if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2])
                return arr[1][1];
            
            if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0])
                return arr[1][1];
            if(arr[1][1]==arr[1][0] && arr[1][1]==arr[1][2])
                return arr[1][1];
            if(arr[1][1]==arr[0][1] && arr[1][1]==arr[2][1])
                return arr[1][1];
        }
        if(arr[1][0]!=0)
        {
            if(arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0])
                return arr[1][0];
        }
        if(arr[0][1]!=0)
        {
            if(arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2])
                return arr[0][1];
        }
        if(arr[2][1]!=0)
        {
            if(arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2])
                return arr[2][1];
        }
          if(arr[1][2]!=0)
        {
            if(arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2])
                return arr[1][2];
        }
          return -1;
    }
    public static void main(String args[])
    {
       
       
    }
}
