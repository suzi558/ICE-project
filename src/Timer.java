import java.util.concurrent.TimeUnit;

public class Timer {
Timer(){

}
   public static void startTimer(){
       try {
               for (int i = 10; i >= 0; i--) {
                   System.out.println(i);
                   TimeUnit.SECONDS.sleep(1);
               }


           } catch(Exception e){
               System.out.println("Noget gik galt");
           }

       finally {
       System.out.println("Time is up ladies and gentlemen!");
       }


       }

    }




