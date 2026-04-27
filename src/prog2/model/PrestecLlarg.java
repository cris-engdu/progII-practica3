package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec{

    public PrestecLlarg(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        super(exemplar_, usuari_, dataCreacio_);
    }

    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    @Override
    public long duradaPrestec() {
        return 140_000L;
    }
}
