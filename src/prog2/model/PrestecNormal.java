package prog2.model;

import java.util.Date;

public class PrestecNormal extends Prestec{

    public PrestecNormal(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        super(exemplar_, usuari_, dataCreacio_);
    }

    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    @Override
    public long duradaPrestec() {
        return 70_000L;
    }
}
