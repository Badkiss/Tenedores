public class Tenedor {
   private int numero;
   private boolean en_Uso;

   Tenedor(int numero){
       this.numero=numero;
       en_Uso=false;
   }

    public int getNumero() {
        return numero;
    }

    public boolean isEn_Uso() {
        return en_Uso;
    }

    public void setEn_Uso(boolean en_Uso) {
        this.en_Uso = en_Uso;
    }

    @Override
    public String toString() {
        return numero+" ";
    }
}
