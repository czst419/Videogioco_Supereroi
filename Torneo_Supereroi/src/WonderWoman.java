class WonderWoman extends Supereroe {
    public WonderWoman() {
        super("Wonder Woman", 650);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Lazo della Verità!");
        this.attacca(avversario, 150);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Bracciali Deflettori!");
        this.protezione = (double)0.5F;
        this.riflessione = 0.3;
        System.out.println(this.nome + " riduce i danni del 50% e riflette il 30% dei danni!");
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a difendersi con i bracciali!");
        this.protezione = 0.4;
        this.riflessione = 0.2;
    }

    public void resettaProtezione() {
        this.protezione = (double)1.0F;
        this.riflessione = (double)0.0F;
    }
}
