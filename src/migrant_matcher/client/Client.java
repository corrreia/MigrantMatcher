package migrant_matcher.client;

import java.util.Scanner;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.MigrantMatcher;

public class Client {
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();
        Scanner scanner = new Scanner(System.in);
                
        //LOCAL ONDE É PREENCHIDOS OS CATALOGOS
        Regiao Norte = new Regiao("Norte");
        app.catalogoRegiao.adicionarRegiao(Norte);

        Regiao Sul = new Regiao("Sul");
        app.catalogoRegiao.adicionarRegiao(Sul);

        Regiao Leste = new Regiao("Leste");
        app.catalogoRegiao.adicionarRegiao(Leste);

        Regiao Oeste = new Regiao("Oeste");
        app.catalogoRegiao.adicionarRegiao(Oeste);


        // app.catalogoAjudas.adicionarAjuda(new Alojamento("936655666", 543, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "pao"));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "ovo"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Sul));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "banana"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Oeste));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "laranja"));


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
