

class CatWoman extends Supereroe {
    public CatWoman() {
        super("Cat-Woman", 300);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Artigli Affilati!");
        this.attacca(avversario, 100);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Agilità Felina!");
        this.protezione = 0.7;
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a ridurre i danni!");
        this.protezione = (double)0.5F;
    }

    public void resettaProtezione() {
        this.protezione = (double)1.0F;
    }
}
