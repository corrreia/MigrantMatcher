package migrant_matcher.app.facade.session;

import migrant_matcher.app.domain.Familia;
import migrant_matcher.app.domain.Membro;
import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.catalogos.CatalogoMigrantes;
import migrant_matcher.app.facade.controllers.PedirAjudaHandler;
import migrant_matcher.app.facade.dto.*;

/**
 * Classe {@code MSession} que representa uma 
 * sessão de um Migrante.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class MSession {
    
    private Migrante migrante;

    /**
     * Construtor privado que cria uma
     * sessão de migrante
     * 
     * @param migrante  - Migrante a iniciar sessão
     */
    private MSession(Migrante migrante) {
        this.migrante = migrante;  
    }

    
    /** 
     * Método que retorna o Handler de pedir ajudas
     * 
     * @return PedirAjudaHandler    - Handler de pedir ajudas
     */
    public PedirAjudaHandler getPedirAjudaHandler() {
        return new PedirAjudaHandler(migrante);
    }

    
    /** 
     * Método que reconhece o migrante que está a tentar iniciar sessão
     * Se este já existe no sistema ou não
     * 
     * @param migrante  - Migrante a iniciar sessão
     * @return MSession  - Sessão do migrante
     */
    public static MSession reconhecerMigrante(MigDTO migrante) {

        if(migrante.getClass().getSimpleName().equals("MigDTO")) {
            if(CatalogoMigrantes.getInstance().migranteExistente(migrante))
                return new MSession(CatalogoMigrantes.getInstance().getMigrante(migrante));
            Migrante m = new Migrante(migrante.getNrTelefone(), migrante.getNome());
            CatalogoMigrantes.getInstance().adicionarMigrante(m);
            return new MSession(m);
        }else{
            if(CatalogoMigrantes.getInstance().migranteExistente(migrante))
                return new MSession(CatalogoMigrantes.getInstance().getMigrante(migrante));
            Familia familia = new Familia(migrante.getNrTelefone(), migrante.getNome());
            for(MembroDTO m : ((FamDTO) migrante).getMembros())
                familia.addMembro(new Membro(m.getNome()));
            CatalogoMigrantes.getInstance().adicionarMigrante(familia);
            return new MSession(familia);
        }
    }

    
    /** 
     * Método que retorna o DTO da familia que tem a
     * sessão iniciada
     * 
     * @return FamDTO   - DTO da familia
     */
    public FamDTO getFamilia() {
        return new FamDTO((Familia) migrante);
    }  

    
    /** 
     * Método que retorna o DTO do migrante que tem a
     * sessão iniciada
     * 
     * @return MigDTO   - DTO do migrante
     */
    public MigDTO getMigrante() {
        return new MigDTO(migrante);
    }
}