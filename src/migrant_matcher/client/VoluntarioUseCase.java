package migrant_matcher.client;

import java.util.List;
import java.util.Scanner;

import migrant_matcher.app.facade.*;
import migrant_matcher.app.facade.handlers.*;
import migrant_matcher.app.facade.session.*;
import migrant_matcher.app.facade.dto.*;

public class VoluntarioUseCase {
    
    public static void run(MigrantMatcher app, Scanner sc1) {
        
        System.out.println("-=MigrantMatcher=-\n");
        System.out.println("Esta aplicacao visa recrutar voluntarios que possam oferecer ajudas a migrantes que delas necessitem.\n");
        System.out.println("Pretende registar como voluntario? (s/n)");
        
        String resposta = sc1.nextLine();

        if (!resposta.equals("s")) { 
            return;
        }

        System.out.println("Por favor, indique o seu numero de Telemovel: ");
        String numeroTelemovel = verificarNrTelemovel(sc1);
            
        VSession currentVoluntarioSession = app.reconhecerVoluntario(numeroTelemovel);
        OferecerAjudaHandler ofh = currentVoluntarioSession.getOferecerAjudaHandler();

        System.out.println("Sessão Iniciada!");
        System.out.println("Por favor, indique o tipo de ajuda que pretende oferecer: (item/alojamento)");
        
        String tipoAjuda = sc1.nextLine();

        if(tipoAjuda.equals("item")){
            System.out.println("Por favor, faca uma breve descricao do item que pretende oferecer: ");
            String descricao = sc1.nextLine();
            ofh.oferecerItem(descricao);
            codigoItem(ofh, sc1);
        }

        if(tipoAjuda.equals("alojamento")){
            System.out.println("Por favor, indique o numero de pessoas que o alojamento alberga: ");
            int nrPessoas = sc1.nextInt();
            sc1.nextLine();

            System.out.println("Escolha uma das Regioes abaixo: ");

            List<RegiaoDTO> regioesDisponiveis = ofh.nPessoasAlberga(nrPessoas);
            
            System.out.print(printRegioesDisponiveis(regioesDisponiveis));
            
            reagiaoAux(ofh, sc1);
        }
    }

	/**
    * Verifica se o nr de telemovel é valido
    * @param String nrTelemovel
    */
    private static boolean isValidPhoneNumber(String nrTelefone) {
        return nrTelefone.matches("\\d{9}");
    }

    private static String verificarNrTelemovel(Scanner sc1){
        boolean validPhoneNumber = false;
        String numeroTelemovel = "";
        while(!validPhoneNumber) {
            numeroTelemovel = sc1.nextLine();
            if(isValidPhoneNumber(numeroTelemovel)) {
                validPhoneNumber = true;
            }
            else {
                System.out.println("Numero de Telemovel invalido!, por favor, tente novamente.");
            }
        }
        return numeroTelemovel;
    }

    private static String printRegioesDisponiveis(List<RegiaoDTO> regioesDisponiveis){
        StringBuilder bob = new StringBuilder();
        for(RegiaoDTO r : regioesDisponiveis){
                bob.append("    - " + r.getNome() + "\n");
        }
        return bob.toString();
    }

    private static void reagiaoAux( OferecerAjudaHandler ofh, Scanner sc1){
        boolean regiaoExiste = false;
        System.out.print("Região: ");
        String regiao = sc1.nextLine();
        RegiaoDTO regiaoEscolhida = new RegiaoDTO(regiao);
        while(!regiaoExiste){
            if(ofh.isValidRegiao(regiaoEscolhida)){
                System.out.println("Regiao do alojamento escolhida com sucesso!");
                System.out.println("Apenas resta confirmar a sua ajuda inserindo o código que recebeu por sms.");
                codigoAloj(regiaoEscolhida, ofh, sc1);
                regiaoExiste = true;
            } else {
                System.out.println("Regiao escolhida não existe, tente outra vez!");
                System.out.print("Região: ");
                regiao = sc1.nextLine();
                regiaoEscolhida = new RegiaoDTO(regiao);
            }
        }
    }

    private static void codigoAloj(RegiaoDTO regiaoEscolhida, OferecerAjudaHandler ofh, Scanner sc1){
        if(ofh.indicarRegiao(regiaoEscolhida)){
            System.out.print("Codigo: ");
            String codigo = sc1.nextLine();
            while(!ofh.indicarCodigo(codigo)){
                System.out.println("Codigo incorreto, tente outra vez! (Ajuda! É do tipo XXX-XXX, hifen eh opcional)");
                System.out.print("Codigo: ");
                codigo = sc1.nextLine();
            }
            System.out.println("A sua ajuda foi registada no sistema. Os migrantes agradecem!");
        }
    }

    private static void codigoItem(OferecerAjudaHandler ofh, Scanner sc1){
        System.out.println("Para terminar, introduza o código que recebeu no seu telemovel: ");
        String codigo = sc1.nextLine();
        if(ofh.indicarCodigo(codigo)){
            System.out.println("A sua ajuda foi registada no sistema. Os migrantes agradecem!");
        } else {
            System.out.println("Codigo incorreto, tente outra vez! (Ajuda! É do tipo XXX-XXX, hifen eh opcional)");
        }
    }
}
