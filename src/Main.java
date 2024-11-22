import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Menu menu = new Menu();
        Moeda moeda = new Moeda();
        int op;

        do {
            menu.exibirMenu();
            op = leitura.nextInt();
            moeda.opcaoSwitch(op);
        }while(op != 0);
    }
}