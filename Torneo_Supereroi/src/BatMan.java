class Batman extends Supereroe {
    public Batman() {
        super("Batman", 850);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Gadget Esplosivi!");
        this.attacca(avversario, 180);
        this.resettaProtezione();
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Armatura Riflettente!");
        this.protezione = 0.8;
        this.riflessione = 0.2;
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a riflettere il 20% del danno subito!");
        this.riflessione = 0.2;
    }

    public void resettaProtezione() {
        this.protezione = (double)1.0F;
        this.riflessione = (double)0.0F;
    }
}
