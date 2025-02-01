
class Astro extends Supereroe {
    public Astro() {
        super("Astro", 1350);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Super Forza!");
        this.attacca(avversario, 300);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Scudo per ridurre i danni del 30%!");
        this.protezione = 0.7;
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a ridurre i danni del 50% nel prossimo attacco!");
        this.protezione = (double)0.5F;
    }

    public void resettaProtezione() {
        this.protezione = (double)1.0F;
    }
}
