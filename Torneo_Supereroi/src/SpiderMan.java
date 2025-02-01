
class SpiderMan extends Supereroe {
    public SpiderMan() {
        super("Spider-Man", 400);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Ragnatela Immobilizzante!");
        this.attacca(avversario, 120);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Riflessi Acrobatici!");
        int dannoEvitato = (int)((double)avversario.energia * 0.3);
        avversario.energia -= dannoEvitato;
        if (avversario.energia < 0) {
            avversario.energia = 0;
        }

        System.out.println(this.nome + " evita " + dannoEvitato + " danni!");
    }

    public void difesa() {
        System.out.println(this.nome + " si prepara a evitare i danni!");
        this.protezione = 0.6;
    }
}
