public class Menu {
    public void exibirMenu(){
        System.out.println("*************************************************************");
        System.out.println("Seja bem-vindo(a) ao Conversor de Moedas -.*\n");
        System.out.println("1) Dólar =>> Peso argentino\n" +
                            "2) Peso argentino =>> Dólar\n" +
                            "3) Dólar =>> Real brasileiro\n" +
                            "4) Real brasileiro =>> Dólar\n" +
                            "5) Dólar =>> Peso colombiano\n" +
                            "6) Peso colombiano =>> Dólar\n" +
                            "7) Dólar =>> Euro\n" +
                            "8) Euro ==> Dólar\n" +
                            "9) Real brasileiro =>> Iene japonês\n" +
                            "10) Iene japonês =>> Dólar\n" +
                            "0) Sair");
        System.out.println("*************************************************************");
        System.out.println("Escolha uma opção válida");
        System.out.print("R: ");
    }

    public void exibirValorDesejado(){
        System.out.println("Digite o valor que deseja converter:");
    }
}
