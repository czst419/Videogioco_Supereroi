

abstract class Supereroe {
    String nome;
    int energia;
    double protezione = (double)1.0F;
    double riflessione = (double)0.0F;

    public Supereroe(String nome, int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    public abstract void usaPotere1(Supereroe var1);

    public abstract void usaPotere2(Supereroe var1);

    public abstract void difesa();

    public void attacca(Supereroe avversario, int danno) {
        int dannoEffettivo = (int)((double)danno * avversario.protezione);
        avversario.energia -= dannoEffettivo;
        int dannoRiflesso = (int)((double)dannoEffettivo * avversario.riflessione);
        if (dannoRiflesso > 0) {
            this.energia -= dannoRiflesso;
        }

        avversario.protezione = (double)1.0F;
        avversario.riflessione = (double)0.0F;
        if (avversario.energia < 0) {
            avversario.energia = 0;
        }

        System.out.println(this.nome + " attacca " + avversario.nome + " infliggendo " + dannoEffettivo + " danni!");
        if (dannoRiflesso > 0) {
            System.out.println(this.nome + " subisce " + dannoRiflesso + " danni riflessi!");
        }

    }

    public boolean isAlive() {
        return this.energia > 0;
    }

    public int getEnergia() {
        return this.energia;
    }

    public String toString() {
        return this.nome + " - Energia: " + this.energia + ", Protezione: " + this.protezione + ", Riflessione: " + this.riflessione;
    }
}
