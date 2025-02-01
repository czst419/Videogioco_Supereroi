

class Flash extends Supereroe {
    public Flash() {
        super("Flash", 500);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Super Velocità!");
        this.attacca(avversario, 200);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " schiva i danni!");
        this.protezione = (double)0.5F;
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a schivare i danni!");
        this.protezione = (double)0.5F;
    }
}
