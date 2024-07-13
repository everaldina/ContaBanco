// desafio: https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/sintaxe

import java.text.DecimalFormat;
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

        System.out.print("Digite o número da conta: ");
        numero = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Digite a agência: ");
        agencia = scanner.nextLine();

        System.out.print("Digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();

        System.out.print("Digite o saldo da conta: ");
        saldo = scanner.nextFloat();

        mensagemSaida = criarMensagemSaida(numero, agencia, nomeCliente, saldo);
        System.out.print("\n" + mensagemSaida);

        scanner.close();
    }

    public static String criarMensagemSaida(int numero, String agencia, String nomeCliente, float saldo) {
        String mensagem = "Olá " + capitalizar(nomeCliente) + ", obrigado por criar uma conta em nosso banco, ";
        mensagem += "sua agência é " + agencia;
        mensagem += ", conta " + numero;
        mensagem+= " e seu saldo R$" + dfSharp.format(numero) + " já está disponível para saque.";

        return mensagem;
    }

    public static String capitalizar(String texto) {
        String textoSeparado[] = texto.toLowerCase().split(" ");
        for (int i = 0; i < textoSeparado.length; i++) {
            textoSeparado[i] = textoSeparado[i].substring(0, 1).toUpperCase() + textoSeparado[i].substring(1);
        }
        return String.join(" ", textoSeparado);
    }
}
