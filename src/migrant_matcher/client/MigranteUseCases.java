package migrant_matcher.client;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import migrant_matcher.app.facade.*;
import migrant_matcher.app.facade.dto.*;
import migrant_matcher.app.facade.handlers.PedirAjudaHandler;
import migrant_matcher.app.facade.session.*;

public class MigranteUseCases {
    public static void run(MigrantMatcher app) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-=MigrantMatcher=-\n");
        System.out.println("Esta aplicacao visa ajudar migrantes que necessitem de apoio em Portugal.\n");
        System.out.println("Registando-se tem acesso a ajudas disponibilizadas por voluntarios de todo o Pais.\n");
        
        boolean ciclo = true;
        while(ciclo) {
            System.out.println("Pretende registar-se? (s/n)");

            String resposta = scanner.nextLine();
            
            if (!resposta.equals("s")) ciclo = false;

            System.out.println("Pretende registar-se individualmente ou como familia? (m/f)");

            String tipo = scanner.nextLine();

            String nome = "";
            String numeroTelemovel = "";

            if(tipo.equals("m")){
                System.out.println("Por favor, indique o seu nome:");
                nome = scanner.nextLine();
                System.out.println("Por favor, indique o seu numero de Telemovel:");

                numeroTelemovel = phone(scanner);

                MSession currentMigranteSession = app.reconhecerMigrante(nome, numeroTelemovel);

                System.out.println("Sessão Iniciada!");

                PedirAjudaHandler handler = currentMigranteSession.getPedirAjudaHandler();

                help(scanner, handler);

                   
            }else if(tipo.equals("f")){
                System.out.println("Por favor, indique o nome do chefe de familia:");

                nome = scanner.nextLine();

                System.out.println("Por favor, indique o numero de telemovel do cabeça de familia:");

                numeroTelemovel = phone(scanner);

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
                
            }else 
                System.out.println("Tipo inválido!");

        }

        scanner.close();
        System.out.println("Programa terminado!");

        
        
    }

    private static String phone(Scanner scanner){
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
                    "    - [" + a.getId() +
                    "] (" + (a.getClass().getName().equals("ItemDTO") ? "ITEM" : "ALOJAMENTO") + ") " +
                    (a.getClass().getName().equals("ItemDTO") ? 
                    ("Item: " + ((ItemDTO) a).getDescricao()) : 
                    ( "Alojamento :" + ((AlojDTO) a).getRegiao().getNome())));
                }

                System.out.println("Por favor, indique o ID da ajuda que pretende pedir:");

                boolean mais = true;
                while(mais) {
                    int id = scanner.nextInt();
                    handler.indicarAjuda(ajudas.stream().filter(a -> a.getId() == id).findFirst().get());
                    System.out.println("Pretende pedir mais ajudas? (s/n)");
                    String resp = scanner.nextLine();
                    if(!resp.equals("s")) mais = true;
                }
                handler.confirmarSelecao();
                System.out.println("Selecao confirmada!, entretanto o voluntario vai entrar em contacto consigo.");
    }

    private static boolean isValidPhoneNumber(String numeroTelemovel) {
        String regex  = "^9[1236]\\d{7}$";
        return numeroTelemovel.matches(regex);
    }
    
}
