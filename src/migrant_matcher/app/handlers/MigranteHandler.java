package migrant_matcher.app.handlers;

import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;

public class MigranteHandler {
     
    private Migrante m;
    private int nPessoas;
    List<Ajuda> ajudas;
    List<Ajuda> ajudasSelecionadas;

    public MigranteHandler(Migrante m, int nPessoas) {
        this.m = m;
        if(nPessoas > 0){
            this.nPessoas = nPessoas;
        }

        this.ajudas = CatalogoAjudas.getInstance().getAjudas();
    }

    public void registarMigrante(){
        
    }






}