public class Threads {
  public static void main(String[] args) {
    try { 
     int i=0;
     while(true) {
       Thread.sleep(1000);
       i++;
       System.out.println(i);
     }
    }  catch (Exception e1) {

    }
  }
}
