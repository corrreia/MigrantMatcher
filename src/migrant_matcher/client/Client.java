package migrant_matcher.client;

import java.util.Scanner;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.factory.OrdAjFactory;
import migrant_matcher.app.facade.MigrantMatcher;

/**
 * A classe {@code Client} serve como main na interação com
 * o utilizador, partindo de ponto de começo para os dois casos 
 * de uso.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Client {
    
    /** 
     * Função main que inicia o programa.
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();
        Scanner scanner = new Scanner(System.in);

        //LOCAL ONDE SÃO PREENCHIDOS OS CATALOGOS
        app.catalogoRegiao.adicionarRegiao(new Regiao("Lisboa"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Porto"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Guarda"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Aveiro"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Coimbra"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Viseu"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Braga"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Portalegre"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Setubal"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Faro"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Beja"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Braganca"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Leiria"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Vila Real"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Castelo Branco"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Santarem"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Evora"));
        app.catalogoRegiao.adicionarRegiao(new Regiao("Viana Do Castelo"));

        
        // Ajudas para testar os casos de uso (Descomentar se necessário)
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("936655666", 543, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "pao"));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "ovo"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Sul));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Norte));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "banana"));
        // app.catalogoAjudas.adicionarAjuda(new Alojamento("966645654", 32, Oeste));
        // app.catalogoAjudas.adicionarAjuda(new Item("966645654", "laranja"));


        //=================================================================================

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
