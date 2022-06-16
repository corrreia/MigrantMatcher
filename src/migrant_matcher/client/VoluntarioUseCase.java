package migrant_matcher.client;

import java.util.List;
import java.util.Scanner;

import migrant_matcher.app.facade.*;
import migrant_matcher.app.facade.handlers.*;
import migrant_matcher.app.facade.session.*;
import migrant_matcher.app.facade.dto.*;

public class VoluntarioUseCase {
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();
        Scanner scanner = new Scanner(System.in);	
        
        System.out.println("-=MigrantMatcher=-");
        System.out.println("Esta aplicacao visa recrutar voluntarios que possam oferecer ajudas a migrantes que delas necessitem.");
        System.out.println("Pretende registar como voluntario? (s/n)");
        
        String resposta = scanner.nextLine();

        if (!resposta.equals("s")) return;

        
        System.out.println("Por favor, indique o seu numero de Telemovel:");
        String numeroTelemovel = scanner.nextLine();
            
        if (!isValidPhoneNumber(numeroTelemovel)) return;
            
        VSession currentVoluntarioSession = app.reconhecerVoluntario(numeroTelemovel);
        OferecerAjudaHandler ofh = currentVoluntarioSession.getOferecerAjudaHandler();

        System.out.println("Sessão Iniciada!");
        System.out.println("Por favor, indique o tipo de ajuda que pretende oferecer: (item/alojamento)");
        
        String tipoAjuda = scanner.nextLine();

        if(tipoAjuda.equals("item")){
            System.out.println("Por favor, faca uma breve descricao do item que pretende oferecer: ");
            String descricao = scanner.nextLine();
            ofh.oferecerItem(descricao);
            System.out.println("Para terminar, introduza o código que recebeu no seu telemovel: ");
            String codigo = scanner.nextLine();
            if(ofh.indicarCodigo(codigo)){
                System.out.println("A sua ajuda foi registada no sistema. Os migrantes agradecem!");
            } else {
                System.out.println("Código incorreto! Tente outra vez! (Ajuda! É do tipo XXX-XXX)");
            }
        }

        if(tipoAjuda.equals("alojamento")){
            System.out.println("Por favor, indique o numero de pessoas que o alojamento alberga: ");
            int nrPessoas = scanner.nextInt();
            System.out.println("Escolha uma das Regioes abaixo: ");

            List<RegiaoDTO> regioesDisponiveis = ofh.nPessoasAlberga(nrPessoas);
            System.out.println(regioesDisponiveis);
            
            RegiaoDTO regiaoEscolhida = new RegiaoDTO(scanner.nextLine());
            if(ofh.indicarRegiao(regiaoEscolhida)){
                System.out.println("Regiao escolhida com sucesso!");
                System.out.println("Apenas resta confirmar a sua ajuda inserindo o código que recebeu por sms.");
                System.out.print("Código: ");
                String codigo = scanner.nextLine();
                if(ofh.indicarCodigo(codigo)){
                    System.out.println("Ajuda confirmada com sucesso!");
                }
                else{
                    System.out.println("Código inválido!");
                }
            }
        }
    }

	//veryfy a portuguese phone nrTelefone
    public static boolean isValidPhoneNumber(String nrTelefone) {
        return nrTelefone.matches("\\d{9}");
    }

    
}
