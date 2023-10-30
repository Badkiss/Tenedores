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
        while (0==0){
            utilizarTenedor();
            reposo();
        }

    }

    public void utilizarTenedor(){
        if (!iz.isEn_Uso() && !der.isEn_Uso()){
            synchronized (iz){
                synchronized (der){
                    try {
                        System.out.println("Filosofo numero " +numero+" esta comiendo con los tenedores "+iz +" "+der);
                        iz.setEn_Uso(true);
                        der.setEn_Uso(true);
                        Thread.sleep(3000);
                        iz.setEn_Uso(false);
                        der.setEn_Uso(false);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Filosofo numero " +numero+" ha terminado de comer con los tenedores "+iz +" "+der);
                }
            }
        }else {
            synchronized (der){
                synchronized (iz){
                    try {
                        System.out.println("Filosofo numero " +numero+" esta comiendo con los tenedores "+iz +" "+der);
                        iz.setEn_Uso(true);
                        der.setEn_Uso(true);
                        Thread.sleep(3000);
                        iz.setEn_Uso(false);
                        der.setEn_Uso(false);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Filosofo numero " +numero+" ha terminado de comer con los tenedores "+iz +" "+der);
                }
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
