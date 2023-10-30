import java.util.List;

public class Main {
    public static void main(String[] args) {

        Tenedor[] tenedores=new Tenedor[5];
        Filosofo[] filosofos=new Filosofo[5];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i]=new Tenedor(i);
        }
        filosofos[0]=new Filosofo(0,tenedores[0],tenedores[4]);
        filosofos[1]=new Filosofo(1,tenedores[0],tenedores[1]);
        filosofos[2]=new Filosofo(2,tenedores[1],tenedores[2]);
        filosofos[3]=new Filosofo(3,tenedores[2],tenedores[3]);
        filosofos[4]=new Filosofo(4,tenedores[3],tenedores[4]);

        Thread[] threads=new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(filosofos[i]);
        }
        for (Thread thread:threads){
            thread.start();
        }
        try {
            for (Thread thread:threads){
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
