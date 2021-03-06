package migrant_matcher.client;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import migrant_matcher.app.facade.*;
import migrant_matcher.app.facade.controllers.PedirAjudaHandler;
import migrant_matcher.app.facade.dto.*;
import migrant_matcher.app.facade.session.*;

/**
 * A classe {@code MigranteUseCase} serve como exemplo do segundo 
 * caso de uso, exemplificando um produto final visto dos olhos
 * do Migrante
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class MigranteUseCase {
    
    /** 
     * Método Run que executa o caso de uso
     * 
     * @param app       - Instância do MigrantMatcher
     * @param scanner   - Scanner para obter os inputs do utilizador
     */
    public static void run(MigrantMatcher app, Scanner scanner) {

        System.out.println("-=MigrantMatcher=-\n");
        System.out.println("Esta aplicacao visa ajudar migrantes que necessitem de apoio em Portugal.\n");
        System.out.println("Registando-se tem acesso a ajudas disponibilizadas por voluntarios de todo o Pais.\n");
        
        boolean ciclo = true;
        while(ciclo) {
            System.out.println("Pretende registar-se? (s/n)");
            if(scanner.nextLine().equals("n")){
                ciclo = false;
                break;
            }

            System.out.println("Pretende registar-se individualmente ou como familia? (i/f)");

            String tipo = scanner.nextLine();

            String nome = "";
            String numeroTelemovel = "";

            if(tipo.equals("i")){
                System.out.println("Por favor, indique o seu nome:");
                nome = scanner.nextLine();
                System.out.println("Por favor, indique o seu numero de Telemovel:");

                numeroTelemovel = verificarNrTelemovel(scanner);

                MSession currentMigranteSession = app.reconhecerMigrante(nome, numeroTelemovel);

                System.out.println("Sessão Iniciada!");

                PedirAjudaHandler handler = currentMigranteSession.getPedirAjudaHandler();

                help(scanner, handler);

                   
            }else if(tipo.equals("f")){
                System.out.println("Por favor, indique o nome do chefe de familia:");

                nome = scanner.nextLine();

                System.out.println("Por favor, indique o numero de telemovel do cabeça de familia:");

                numeroTelemovel = verificarNrTelemovel(scanner);

                List<MembroDTO> membros = new LinkedList<MembroDTO>();

                boolean finished = false;
                while(!finished){
                    System.out.println("Por favor, indique o nome do membro:");
                    nome = scanner.nextLine();
                    membros.add(new MembroDTO(nome));
                    System.out.println("Pretende adicionar mais membros? (s/n)");
                    String resposta2 = scanner.nextLine();
                    if(!resposta2.equals("s")) finished = true;
                }

                MSession currentFamiliaSession = app.reconhecerFamilia(nome, numeroTelemovel, membros);

                System.out.println("Sessão Iniciada!");

                PedirAjudaHandler handler = currentFamiliaSession.getPedirAjudaHandler();

                help(scanner, handler);
                
            }else{
                System.out.println("Tipo inválido!");
                break;
            }
        }
        System.out.println("Programa terminado!");
    }

    
    /** 
     * Método que verifica se um certo numero de
     * telemovel é válido, se não for pede ao utilizador
     * novamente até encontrar um que seja valido
     * 
     * @param scanner   - Scanner para obter os inputs do utilizador
     * @return String   - Numero de telemovel valido
     */
    private static String verificarNrTelemovel(Scanner scanner){
        boolean validPhoneNumber = false;
        String numeroTelemovel = "";
        while(!validPhoneNumber) {
            numeroTelemovel = scanner.nextLine();
            if(isValidPhoneNumber(numeroTelemovel)) {
                validPhoneNumber = true;
            }
            else {
                System.out.println("Numero de Telemovel inválido!, por favor, tente novamente.");
            }
        }
        return numeroTelemovel;
    }

    
    /** 
     * Método que lida com todo o processo depois do Registo
     * bem feito. 
     * Mostra as regiões disponiveis, as ajudas disponiveis
     * consoante a região escolhida e confirma a seleção
     * quando o utilizaqr estiver satisfeito
     * 
     * @param scanner   - Scanner para obter os inputs do utilizador
     * @param handler   - Handler para pedir ajuda
     */
    private static void help(Scanner scanner, PedirAjudaHandler handler) {
        System.out.println("Regioes disponiveis: "); 

        for(RegiaoDTO r : handler.regioesDisponiveis()){
            System.out.println("    - " + r.getNome());
        }

        List<AjudaDTO> ajudas = null;

        boolean validReg = false;
        while(!validReg) {
            System.out.println("Por favor, indique a regiao:");
            String regiao = scanner.nextLine();

            ajudas = handler.indicarRegiao(new RegiaoDTO(regiao));

            if(ajudas != null)
                validReg = true;
            else 
                System.out.println("Regiao inválida!, por favor, tente novamente.");
        }

        System.out.println("Estas sao as ajudas disponiveis nessa regiao: ");

        for(AjudaDTO a : ajudas){
            System.out.println(
            "    - [" + a.getId() + "] " +
                (a instanceof ItemDTO ? 
                ("Item: " + ((ItemDTO) a).getDescricao()) : 
                ("Alojamento : " + ((AlojDTO) a).getRegiao().getNome()))
            );
        }

        boolean mais = true;
        while(mais) {
            System.out.println("Por favor, indique o ID da ajuda que pretende pedir:");
            int id = scanner.nextInt();
            scanner.nextLine();
            handler.indicarAjuda(ajudas.stream().filter(a -> a.getId() == id).findFirst().get());
            System.out.println("Pretende pedir mais ajudas? (s/n)");
            if(!scanner.nextLine().equals("s")) mais = false;
        }

        List<AjudaDTO> ajudasPedidas = handler.confirmarSelecao();

        if(ajudasPedidas != null) {
            System.out.println("Selecao confirmada!\n" + ajudasPedidas + "\nEentretanto o voluntario vai entrar em contacto consigo.");
        }
        else
            System.out.println("Algo correu mal.");
    }

    
    /** 
     * Método que verifica a validade de
     * um numero de telemovel
     * 
     * @param numeroTelemovel   - Numero de telemovel a verificar
     * @return boolean          - True se for valido, false se não for
     */
    private static boolean isValidPhoneNumber(String numeroTelemovel) {
        String regex  = "^9[1236]\\d{7}$";
        return numeroTelemovel.matches(regex);
    }
    
}
