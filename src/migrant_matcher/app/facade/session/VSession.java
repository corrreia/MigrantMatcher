package migrant_matcher.app.facade.session;

import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoVoluntario;
import migrant_matcher.app.facade.controllers.OferecerAjudaHandler;
import migrant_matcher.app.facade.dto.VolDTO;

/**
 * Classe {@code VSession} que representa uma 
 * sessão de um voluntário.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class VSession {

    private Voluntario voluntario;

    /**
     * Construtor private para inicio de sessão 
     * de voluntario
     * 
     * @param voluntario    - Voluntário a iniciar sessão
     */
    private VSession(Voluntario voluntario) {
        this.voluntario = voluntario;  
    }

    
    /** 
     * Método que retorna um DTO do voluntario que tem a 
     * sessão iniciada
     * 
     * @return VolDTO   - DTO do voluntario
     */
    public VolDTO getVoluntario() {
        return new VolDTO(voluntario);
    }

    
    /** 
     * Método que retorna o Handler de oferecer ajudas
     * 
     * @return OferecerAjudaHandler  - Handler de oferecer ajudas
     */
    public OferecerAjudaHandler getOferecerAjudaHandler() {
        return new OferecerAjudaHandler(voluntario);
    }

    
    /** 
     * Método que reconhece o voluntário que está a tentar iniciar sessão
     * Se este já existe no sistema ou não
     * 
     * @param voluntario    - Voluntário a iniciar sessão
     * @return VSession     - Sessão do voluntário
     */
    public static VSession reconhecerVoluntario(VolDTO voluntario) {
        if(CatalogoVoluntario.getInstance().voluntarioExistente(voluntario)) {
            return new VSession(CatalogoVoluntario.getInstance().getVoluntario(voluntario));
        }
        return new VSession(CatalogoVoluntario.getInstance().adicionarVoluntario(new Voluntario(voluntario.getNrTelefone())));
    }



}