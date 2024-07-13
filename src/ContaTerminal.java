
/**
 * Desafio para prática de sintaxe em Java
 * Um terminal de conta bancária que solicita ao usuário o número da conta, agência, nome do cliente e saldo da conta.
 * Desafio para o bootcamp da Santander Coders | Java - Digital Innovation One
 * link: https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/sintaxe
 * 
 * @author: everaldina
 * @version: 1.0.0
 * @since: 2022-07-13
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    private static final DecimalFormat dfSharp = new DecimalFormat("0.00");
    public static void main(String[] args) throws Exception {
        int numero;
        String agencia;
        String nomeCliente;
        float saldo;
        String mensagemSaida;

        Locale localeBr = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in).useLocale(localeBr);

        try{
            System.out.print("Digite o número da conta: ");
            numero = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Número de conta inválido, tente novamente.");
            scanner.close();
            return;
        }
        scanner.nextLine(); // limpar buffer

        System.out.print("Digite a agência: ");
        agencia = scanner.nextLine();

        System.out.print("Digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();

        try{
            System.out.print("Digite o saldo da conta: ");
            saldo = scanner.nextFloat();
        }catch(InputMismatchException e){
            System.out.println("Saldo inválido, tente novamente.");
            scanner.close();
            return;
        }

        mensagemSaida = criarMensagemSaida(numero, agencia, nomeCliente, saldo);
        System.out.print("\n" + mensagemSaida);

        scanner.close();
    }

    /**
     * Cria a mensagem de saída com os dados da conta
     * @param numero Número da conta
     * @param agencia Agência da conta
     * @param nomeCliente Nome do cliente
     * @param saldo Saldo da conta
     * 
     * @return Mensagem de saída com o saldo formatado com duas casas decimais e o nome do cliente capitalizado
     */
    public static String criarMensagemSaida(int numero, String agencia, String nomeCliente, float saldo) {
        String mensagem = "Olá " + capitalizar(nomeCliente) + ", obrigado por criar uma conta em nosso banco, ";
        mensagem += "sua agência é " + agencia;
        mensagem += ", conta " + numero;
        mensagem+= " e seu saldo R$" + dfSharp.format(numero) + " já está disponível para saque.";

        return mensagem;
    }

    /**
     * Capitaliza a primeira letra de cada palavra de um texto
     * @param texto Texto a ser capitalizado
     * @return Texto com a primeira letra de cada palavra capitalizada
     */
    public static String capitalizar(String texto) {
        String textoSeparado[] = texto.toLowerCase().split(" ");
        for (int i = 0; i < textoSeparado.length; i++) {
            textoSeparado[i] = textoSeparado[i].substring(0, 1).toUpperCase() + textoSeparado[i].substring(1);
        }
        return String.join(" ", textoSeparado);
    }
}
