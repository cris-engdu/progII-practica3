package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec{

    public PrestecLlarg(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        super(exemplar_, usuari_, dataCreacio_);
    }
/** es defineix el tipus de prestec*/
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }
/** es defineix la durada del prestec*/
    @Override
    public long duradaPrestec() {
        return 140_000L;
    }
}
