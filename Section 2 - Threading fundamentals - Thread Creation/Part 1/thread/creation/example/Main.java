package thread.creation.example;

public class Main {
   // InterruptedException may occur on sleep
   public static void main(String[] args) throws InterruptedException {
      // Thread object is passed an anonymous class that implements the
      // Runnable interface
      Thread thread = new Thread(new Runnable() {
         @Override
         // Code in run will be executed as soon as the thread is
         // scheduled by the OS
         public void run() {
            System.out.println("We are in thread " + Thread.currentThread().getName());
            // Get static priority of current thread
            System.out.println("Current thread priority is: " + Thread.currentThread().getPriority());
         }
      });
      // Gives thread a recognizable name
      thread.setName("New Worker Thread");
      // Sets the static priority part of the dynamic priority
      // equation to its maximum value, 10
      thread.setPriority(Thread.MAX_PRIORITY);
      // Thread.currentThread() is the current Thread object
      // .getName() gets the name of the thread
      System.out.println("We are in thread: " + Thread.currentThread().getName() +
            " before starting a new thread.");
      // Starts the thread. Scheduling this thread will take
      // some time though so the run method may run after the next line
      thread.start();
      System.out.println("We are in thread: " + Thread.currentThread().getName() +
            " after starting a new thread.");
      // Puts thread to sleep for a number of milliseconds
      // This does not spin in a loop! Instead this command
      // instructs the OS to not schedule the current thread
      // until that time passes. During this time, this thread
      // is not consuming any CPU
      Thread.sleep(1000);
   }
}
