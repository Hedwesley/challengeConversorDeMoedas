import java.util.Scanner;


public class Moeda {
    public void opcaoSwitch(int op){
        Menu menu = new Menu();
        Scanner leitura = new Scanner(System.in);
        switch (op){
            case 1:
                menu.exibirValorDesejado();
                Double valorDesejado = leitura.nextDouble();
                ConversaoMoeda("USD","ARS", valorDesejado);
                break;
            case 2:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("ARS","USD", valorDesejado);
                break;
            case 3:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("USD","BRL", valorDesejado);
                break;
            case 4:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("BRL","USD", valorDesejado);
                break;
            case 5:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("USD","COP", valorDesejado);
                break;
            case 6:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("COP","USD", valorDesejado);
                break;
            case 7:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("USD","EUR", valorDesejado);
                break;
            case 8:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("EUR","USD", valorDesejado);
                break;
            case 9:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("BRL","JPY", valorDesejado);
                break;
            case 10:
                menu.exibirValorDesejado();
                valorDesejado = leitura.nextDouble();
                ConversaoMoeda("JPY","USD", valorDesejado);
                break;
            case 0:
                System.out.println("Obrigado pela preferência!\nVolte sempre!");
                break;
            default:
                System.out.println("Digite um valor válido!");
                break;
        }
    }

    public void ConversaoMoeda(String moedaAtual, String moedaDeseja, Double valorDesejado){
        CotacaoService service = new CotacaoService();
        try {
            Double cotacao = service.buscaCotacao(moedaDeseja, moedaAtual);
            Double cambio = cotacao*valorDesejado;
            System.out.println("Valor " + valorDesejado + "[" + moedaAtual + "] correspode ao valor final de =>>> " +
                    cambio + " [" + moedaDeseja + "]");
            //System.out.println("Cotação de " + moedaDeseja + ": " + cotacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
