package migrant_matcher.client;

import java.util.List;
import java.util.Scanner;

import migrant_matcher.app.facade.*;
import migrant_matcher.app.facade.controllers.*;
import migrant_matcher.app.facade.session.*;
import migrant_matcher.app.facade.dto.*;

/**
 * A classe {@code VoluntarioUseCase} serve como exemplo do primeiro
 * caso de uso, exemplificando um produto final visto dos olhos
 * do Voluntario
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class VoluntarioUseCase {
    
    /** 
     * Método Run que executa o caso de uso
     * 
     * @param app    - Instância do MigrantMatcher
     * @param sc1    - Scanner para obter os inputs do utilizador
     */
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
        OferecerAjudaHandler oah = currentVoluntarioSession.getOferecerAjudaHandler();

        System.out.println("Sessão Iniciada!");
        System.out.println("Por favor, indique o tipo de ajuda que pretende oferecer: (item/alojamento)");
        
        String tipoAjuda = sc1.nextLine();

        if(tipoAjuda.equals("item")){
            System.out.println("Por favor, faca uma breve descricao do item que pretende oferecer: ");
            String descricao = sc1.nextLine();
            oah.oferecerItem(descricao);
            codigoItem(oah, sc1);
        }

        if(tipoAjuda.equals("alojamento")){
            System.out.println("Por favor, indique o numero de pessoas que o alojamento alberga: ");
            int nrPessoas = sc1.nextInt();
            sc1.nextLine();

            System.out.println("Escolha uma das Regioes abaixo: ");

            List<RegiaoDTO> regioesDisponiveis = oah.nPessoasAlberga(nrPessoas);
            
            System.out.print(printRegioesDisponiveis(regioesDisponiveis));
            
            reagiaoAux(oah, sc1);
        }
    }

	/**
    * Verifica se o nr de telemovel é valido
    * @param String nrTelemovel
    */
    private static boolean isValidPhoneNumber(String nrTelefone) {
        return nrTelefone.matches("\\d{9}");
    }

    
    /** 
    * Método que verifica se um certo numero de
    * telemovel é válido, se não for pede ao utilizador
    * novamente até encontrar um que seja valido
    * 
    * @param scanner   - Scanner para obter os inputs do utilizador
    * @return String   - Numero de telemovel valido
    */
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

    
    /** 
     * Método que devolve um string que irá mostrar 
     * ao utilizador a lista de regiões disponiveis
     * 
     * @param regioesDisponiveis    - Lista de regiões disponiveis
     * @return String               - String que mostra a lista de regiões disponiveis
     */
    private static String printRegioesDisponiveis(List<RegiaoDTO> regioesDisponiveis){
        StringBuilder bob = new StringBuilder();
        for(RegiaoDTO r : regioesDisponiveis){
                bob.append("    - " + r.getNome() + "\n");
        }
        return bob.toString();
    }

    
    /** 
     * Método auxiliar que permite ao utilizador escolher a regiao 
     * do alojamento que pretende oferecer desde que esteja disponivel
     * 
     * @param oah   - OferecerAjudaHandler  
     * @param sc1   - Scanner para obter os inputs do utilizador
     */
    private static void reagiaoAux(OferecerAjudaHandler oah, Scanner sc1){
        boolean regiaoExiste = false;
        System.out.print("Região: ");
        String regiao = sc1.nextLine();
        RegiaoDTO regiaoEscolhida = new RegiaoDTO(regiao);
        while(!regiaoExiste){
            if(oah.isValidRegiao(regiaoEscolhida)){
                System.out.println("Regiao do alojamento escolhida com sucesso!");
                System.out.println("Apenas resta confirmar a sua ajuda inserindo o código que recebeu por sms.");
                codigoAloj(regiaoEscolhida, oah, sc1);
                regiaoExiste = true;
            } else {
                System.out.println("Regiao escolhida não existe, tente outra vez!");
                System.out.print("Região: ");
                regiao = sc1.nextLine();
                regiaoEscolhida = new RegiaoDTO(regiao);
            }
        }
    }

    
    /** 
     * Método que confirma a introdução do alojamento no sistema
     * através de um código enviado por sms para o utlizador.
     * Só é confirmada a ajuda quando utilizador inserir o código correto
     * 
     * @param regiaoEscolhida   - RegiaoDTO que representa a regiao escolhida pelo utilizador
     * @param oah               - OferecerAjudaHandler
     * @param sc1               - Scanner para obter os inputs do utilizador
     */
    private static void codigoAloj(RegiaoDTO regiaoEscolhida, OferecerAjudaHandler oah, Scanner sc1){
        if(oah.indicarRegiao(regiaoEscolhida)){
            System.out.print("Codigo: ");
            String codigo = sc1.nextLine();
            while(!oah.indicarCodigo(codigo)){
                System.out.println("Codigo incorreto, tente outra vez! (Ajuda! É do tipo XXX-XXX, hifen eh opcional)");
                System.out.print("Codigo: ");
                codigo = sc1.nextLine();
            }
            System.out.println("A sua ajuda foi registada no sistema. Os migrantes agradecem!");
        }
    }

    
    /** 
     * Método que confirma a introdução do Item no sistema
     * através de um código enviado por sms para o utlizador.
     * Só é confirmada a ajuda quando utilizador inserir o código correto
     * 
     * @param oah   - OferecerAjudaHandler
     * @param sc1   - Scanner para obter os inputs do utilizador
     */
    private static void codigoItem(OferecerAjudaHandler oah, Scanner sc1){
        System.out.println("Para terminar, introduza o código que recebeu no seu telemovel: ");
        String codigo = sc1.nextLine();
        if(oah.indicarCodigo(codigo)){
            System.out.println("A sua ajuda foi registada no sistema. Os migrantes agradecem!");
        } else {
            System.out.println("Codigo incorreto, tente outra vez! (Ajuda! É do tipo XXX-XXX, hifen eh opcional)");
        }
    }
}
