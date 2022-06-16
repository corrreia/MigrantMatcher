package migrant_matcher.client;

import java.util.Scanner;

import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.facade.MigrantMatcher;

public class Client {
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();
        Scanner scanner = new Scanner(System.in);
        
                
        //LOCAL ONDE É PREENCHIDOS OS CATALOGOS
        app.catalogoRegiao.adicionarRegiao(new Regiao("Norte"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Sul"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Leste"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Oeste"));

        //=====================================

        boolean stop = false;
        while(!stop){

            System.out.println("Fazer a vez de voluntario ou migrante/familia? (v/m)");
            String resposta = scanner.nextLine();

            if(resposta.equals("v"))
                VoluntarioUseCase.run(app, scanner);
            else if(resposta.equals("m"))
                MigranteUseCase.run(app, scanner);

            //perguntar se pretende imprimir todos os catalogos
            System.out.println("Pretende imprimir todos os catalogos? (s/n)");
            if(scanner.nextLine().equals("s"))
                System.out.println(app.toStringCatalogos());

            System.out.println("PARAR O PROGRAMA? (s/n)");
            if(scanner.nextLine().equals("s"))stop = true;
        }
        scanner.close();
    }
}
