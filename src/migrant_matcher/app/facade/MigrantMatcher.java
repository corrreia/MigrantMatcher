package migrant_matcher.app.facade;

import java.util.List;

import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoMigrantes;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.catalogos.CatalogoVoluntario;
import migrant_matcher.app.facade.dto.FamDTO;
import migrant_matcher.app.facade.dto.MembroDTO;
import migrant_matcher.app.facade.dto.MigDTO;
import migrant_matcher.app.facade.dto.VolDTO;
import migrant_matcher.app.facade.session.MSession;
import migrant_matcher.app.facade.session.VSession;

/**
 * Classe {@code MigrantMatcher} que representa o sistema da
 * aplicação.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class MigrantMatcher {

    private CatalogoAjudas catalogoAjudas;   
    private CatalogoMigrantes catalogoMigrantes;
    private CatalogoVoluntario catalogoVoluntario;  
    public CatalogoRegiao catalogoRegiao;  //apenas publico devido ao facto de ter que ser preenchido em Client.java 
    // na versao final não devem existir
    // pois podem gerar problemas de segurança

    /**
     * Construtor que inicializa o sistema.
     */
    public MigrantMatcher() {
        this.catalogoAjudas = CatalogoAjudas.getInstance();
        this.catalogoMigrantes = CatalogoMigrantes.getInstance();
        this.catalogoVoluntario = CatalogoVoluntario.getInstance();
        this.catalogoRegiao = CatalogoRegiao.getInstance();
    }
    
    
    /** 
     * Método que reconhece o voluntário e que cria uma sessão para
     * o mesmo.
     * 
     * @param nrTelefone    - Número de telemóvel do voluntário
     * @return VSession     - Sessão do voluntário
     */
    public VSession reconhecerVoluntario(String nrTelefone) {
        return VSession.reconhecerVoluntario(new VolDTO(nrTelefone));
    }

    
    /** 
     * Método que reconhece o migrante e que cria uma sessão para
     * o mesmo.
     * 
     * @param nrTelefone    - Número de telemóvel do migrante
     * @param nome          - Nome do migrante
     * @return MSession     - Sessão do migrante
     */
    public MSession reconhecerMigrante(String nrTelefone, String nome) {
        return MSession.reconhecerMigrante(new MigDTO(nome, nrTelefone));
    }

    
    /** 
     * Método que reconhece o migrante e que cria uma sessão para
     * o mesmo.
     * 
     * @param nrTelefone    - Número de telemóvel do chefe de familia
     * @param nome          - Nome do chefe de familia          
     * @param membros       - Lista de membros da familia
     * @return MSession     - Sessão do migrante
     */
    public MSession reconhecerFamilia(String nrTelefone, String nome, List<MembroDTO> membros) {
        return MSession.reconhecerMigrante(new FamDTO(nome, nrTelefone, membros));
    }

    //==========================================================================================
    // Os Getters abaixo são apenas para testes, numa versão final não devem existir
    // pois podem gerar problemas de segurança
    //==========================================================================================
    
    /** 
     * Método para imprimir os Catálogos, serve apenas para se testarem os
     * casos de uso. Mais tarde deve ser retirado pois afeta a 
     * segurança da aplicação
     * 
     * @return String   - String com os catálogos
     */
    public String toStringCatalogos() {
        return "Catalogo de Ajudas: \n" + catalogoAjudas.toString() + "\n" +
                "Catalogo de Migrantes: \n" + catalogoMigrantes.toString() + "\n" +
                "Catalogo de Voluntarios: \n" + catalogoVoluntario.toString() + "\n" +
                "Catalogo de Regiao: \n" + catalogoRegiao.toString();
    }

    /**
     * Método que apaga o conteudo de todos os Catálogos.
     * serve apenas para se testarem os
     * casos de uso. Mais tarde deve ser retirado pois afeta a 
     * segurança da aplicação
     */
    public void wipeCatalogos(){
        catalogoAjudas.wipeCatalogo();
        catalogoMigrantes.wipeCatalogo();
        catalogoVoluntario.wipeCatalogo();
        catalogoRegiao.wipeCatalogo();
    }

    /** 
     * Método que retorna o catalogo de Ajudas.
     * Serve apenas para se testes os
     * casos de uso. Mais tarde deve ser retirado pois afeta a 
     * segurança da aplicação
     * 
     * @return CatalogoAjudas   - Catalogo de Ajudas
     */
    public CatalogoAjudas getCatalogoAjudas() {
        return catalogoAjudas;
    }

    
    /** 
     * Método que retorna o catalogo de Regioes.
     * Serve apenas para se testes os
     * casos de uso. Mais tarde deve ser retirado pois afeta a 
     * segurança da aplicação
     * 
     * @return catalogoRegiao   - Catalogo de Regiao
     */
    public CatalogoRegiao getCatalogoRegiao() {
        return catalogoRegiao;
    }

    
    /** 
     * Método que retorna o catalogo de Migrantes.
     * Serve apenas para se testes os
     * casos de uso. Mais tarde deve ser retirado pois afeta a 
     * segurança da aplicação
     * 
     * @return catalogoMigrantes  - Catalogo de Migrantes
     */
    public CatalogoMigrantes getCatalogoMigrantes() {
        return catalogoMigrantes;
    }

}
