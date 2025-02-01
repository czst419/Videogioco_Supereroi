
class Hulk extends Supereroe {
    public Hulk() {
        super("Hulk", 1200);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Distruzione al Suolo!");
        this.attacca(avversario, 250);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " riduce l'attacco del nemico del 10%!");
        avversario.protezione = 0.9;
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a difendersi con la sua Resistenza!");
        this.protezione = 0.7;
    }
}
