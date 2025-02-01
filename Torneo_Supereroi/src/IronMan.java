
class IronMan extends Supereroe {
    public IronMan() {
        super("Iron Man", 900);
    }

    public void usaPotere1(Supereroe avversario) {
        System.out.println(this.nome + " usa Cannoni a Energia!");
        this.attacca(avversario, 220);
    }

    public void usaPotere2(Supereroe avversario) {
        System.out.println(this.nome + " usa Armatura Rigenerativa per riparare 200 punti vita!");
        this.energia += 200;
        if (this.energia > 900) {
            this.energia = 900;
        }

        System.out.println(this.nome + " ora ha " + this.energia + " energia.");
    }

    public void difesa() {
        System.out.println(this.nome + " usa Scudo Tecnologico per ridurre i danni!");
        this.protezione = 0.7;
    }
}
