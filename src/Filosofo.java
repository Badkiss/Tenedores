public class Filosofo implements Runnable{
   private int numero;
   private Tenedor der;
   private Tenedor iz;

   Filosofo(int numero,Tenedor der,Tenedor iz){
       this.numero=numero;
       this.der=der;
       this.iz=iz;
   }
    @Override
    public void run() {
        while (true){
            utilizarTenedor();
            reposo();
        }

    }


    public  void utilizarTenedor(){


           synchronized (der){
               synchronized (iz){
                   try {
                       System.out.println("Filosofo numero " +numero+" esta comiendo con los tenedores "+iz +" "+der);
                       Thread.sleep(3000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   System.out.println("Filosofo numero " +numero+" ha terminado de comer con los tenedores "+iz +" "+der);
               }
           }


    }

   public void reposo(){
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }


   }
}
