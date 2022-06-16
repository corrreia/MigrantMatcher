package migrant_matcher.client;

import java.util.Scanner;

// import migrant_matcher.app.domain.Alojamento;
// import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.factory.OrdAjFactory;
import migrant_matcher.app.facade.MigrantMatcher;

public class Client {
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();
        Scanner scanner = new Scanner(System.in);
                
        //LOCAL ONDE SÃO PREENCHIDOS OS CATALOGOS
        Regiao Lisboa = new Regiao("Lisboa");
        app.catalogoRegiao.adicionarRegiao(Lisboa);

        Regiao Porto = new Regiao("Porto");
        app.catalogoRegiao.adicionarRegiao(Porto);

        Regiao Guarda = new Regiao("Guarda");
        app.catalogoRegiao.adicionarRegiao(Guarda);

        Regiao Aveiro = new Regiao("Aveiro");
        app.catalogoRegiao.adicionarRegiao(Aveiro);

        Regiao Coimbra = new Regiao("Coimbra");
        app.catalogoRegiao.adicionarRegiao(Coimbra);

        Regiao Viseu = new Regiao("Viseu");
        app.catalogoRegiao.adicionarRegiao(Viseu);

        Regiao Braga = new Regiao("Braga");
        app.catalogoRegiao.adicionarRegiao(Braga);

        Regiao Portalegre = new Regiao("Portalegre");
        app.catalogoRegiao.adicionarRegiao(Portalegre);

        Regiao Setubal = new Regiao("Setubal");
        app.catalogoRegiao.adicionarRegiao(Setubal);

        Regiao Faro = new Regiao("Faro");
        app.catalogoRegiao.adicionarRegiao(Faro);

        Regiao Beja = new Regiao("Beja");
        app.catalogoRegiao.adicionarRegiao(Beja);

        Regiao Braganca = new Regiao("Braganca");
        app.catalogoRegiao.adicionarRegiao(Braganca);

        Regiao Leiria = new Regiao("Leiria");
        app.catalogoRegiao.adicionarRegiao(Leiria);

        Regiao Vila_Real = new Regiao("Vila Real");
        app.catalogoRegiao.adicionarRegiao(Vila_Real);

        Regiao Castelo_Branco = new Regiao("Castelo Branco");
        app.catalogoRegiao.adicionarRegiao(Castelo_Branco);

        Regiao Santarem = new Regiao("Santarem");
        app.catalogoRegiao.adicionarRegiao(Santarem);

        Regiao Evora = new Regiao("Evora");
        app.catalogoRegiao.adicionarRegiao(Evora);

        Regiao VianaDoCastelo = new Regiao("Viana Do Castelo");
        app.catalogoRegiao.adicionarRegiao(VianaDoCastelo);

        // app.catalogoAjudas.adicionarAjuda(new Alojamento("936655666", 543, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "pao"));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "ovo"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Sul));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "banana"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Oeste));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "laranja"));


        //=====================================

        System.out.println( OrdAjFactory.getInstance().getOrdAjStrat("migrant_matcher.app.strategies.ord.OrdAjById").getClass().getName() );

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
