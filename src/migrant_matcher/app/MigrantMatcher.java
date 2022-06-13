package migrant_matcher.app;

import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.handlers.VoluntarioHandler;

public class MigrantMatcher {
    public static void main(String[] args) {

        Voluntario v = new Voluntario("123456789");

        VoluntarioHandler vh = new VoluntarioHandler(v);

        vh.oferecerItem("lkfdsjhf");
         

    }
}
