package principal;

import java.util.Scanner;

public class CadastroVoos {
    //var global
    static Scanner leia = new Scanner(System.in);
    static String empAerea[] = new String[3]; //armazena o nome da companhia
    static String codVoo[] = new String[3]; //armazena o numero do voo
    static String RG[] = new String[4]; //guarda o RG do passageiro
    static int dispL[] = new int[3]; //armazena a qtd de lugares
    static boolean vaz[] = new boolean[3]; //indica se a posi��o est� vazia
    static int k[] = new int[3]; //guarda o a qtd de lugares de cada voo
    static int i = 0, j = 0;; //variavel usada nos la�os
   
    public static void main(String[] args) {
        //declara��o de vari�veis locais
        int menuV = 0; //menu do voo
        int menuP = 0; //menu principal
        int codV = 100; //codigo do voo para sele��o
       
      
        //indicar� que a posi��o est� vazia
        for (i = 0; i < empAerea.length; i++) {
            vaz[i] = false;
        }
        //inicializar o vetor
        for (i = 0; i < empAerea.length; i++) {
            RG[i] = "";
        }
        do {
            if (j <=1) {
                System.out.println("PS:Para o primeiro acesso � necessario cadastrar a companhia aerea");
                j = j+1;
            }
            System.out.println("\nMenu Principal:"
                    + "\n1 - Menu Voo - Cadastro da Companhia Aerea"
                    + "\n2 - Reserva de Passagens"
                    + "\n3 - Ver disponibilidade de lugares"
                    + "\n4 - Cancelamento de Reserva"
                    + "\n5 - Fechar programa");
            menuP = leia.nextInt();

            switch (menuP) {
                case 1:
                    do {
                        if (j <= 1) {
                            System.out.println("\nPS:A op��o 1 faz o cadastro autom�tico de 3 companhias aereas");
                            j = j+1;
                        }
                        System.out.println("\nMenu Voo:"
                                + "\n1 - Cadastrar"
                                + "\n2 - Cancelar Voo"
                                + "\n3 - Ver Op��es de Voo"
                                + "\n4 - Voltar ao Menu Principal");
                       
                        menuV = leia.nextInt();
                        switch (menuV) {
                            case 1:
                                //Cadastramento automatico
                                System.out.println("CADASTRAMENTO DE VOO");
                                CadastrarVoo(codVoo[0]); //fun��o cadastrar
                                break;
                            case 2:
                                System.out.println("CANCELAMENTO DE VOO");
                                System.out.print("Informe o codigo do Voo: ");
                                codV = leia.nextInt();
                                CancelarVoo(codV); //fun��o cancelar voo
                                codV = 100; //reinicializa o codigo do voo
                                break;
                            case 3:
                                System.out.println("DISPONIBILIDADE DE VOO");
                                OpcoesVoo(i); //fun��o ver op��es de voo
                                break;
                            case 4:
                                break;
                        } //fim do switch
                    } while (menuV != 4); //fim do la�o de repeti��o
                    break;
                case 2:
                    System.out.print("RESERVA");
                    Reserva(codV); //fun��o reserva de passagens
                    break;
                case 3:
                    System.out.print("VER RESERVA\n");
                    System.out.print("Informe o codigo do Voo:");
                    codV = leia.nextInt();
                    VerReserva(codV); //fun��o ver reservas
                    break;
                case 4:
                    System.out.print("CANCELAR RESERVA\n");
                    System.out.print("Informe o codigo do Voo:");
                    codV = leia.nextInt();
                    CancelarRe(codV); //Fun��o cancelar reserva
                    break;
                case 5:
                    System.out.println("FECHAR PROGRAMA");
                    break;
            } //fim do switch
        } while (menuP != 5);
    } //fim do main

/*-------------------------------------------------------------------------------------------
 *                                   CADASTRAR VOO
 * ------------------------------------------------------------------------------------------*/
    public static void CadastrarVoo(String a) {
        codVoo[0] = "001";
        empAerea[0] = "TAM";
        dispL[0] = 10;
        vaz[0] = true;
        k[0] = dispL[0];

        codVoo[1] = "002";
        empAerea[1] = "GOL";
        dispL[1] = 8;
        vaz[1] = true;
        k[1] = dispL[1];
       
        codVoo[2] = "003";
        empAerea[2] = "TAP";
        dispL[2] = 20;
        vaz[2] = true;
        k[2] = dispL[2];

        System.out.println("Cadastro realizado com sucesso!");
    } //fim da fun��o cadastrar
/*-------------------------------------------------------------------------------------------
 *                                 CANCELAR DE VOO
 * ------------------------------------------------------------------------------------------*/
    public static void CancelarVoo(int codV) {
        if (codV > 0) {
            codVoo[codV - 1] = ""; //apaga o codigo do voo
            empAerea[codV - 1] = ""; //apaga o nome da empresa
            dispL[codV - 1] = 0; //apaga o numero de lugares
            vaz[codV - 1] = false; //indica que a posi��o est� vazia
        } else {
            System.out.println("C�digo invalido!");
        }
        System.out.println("Opera��o realizada com sucesso!");
    } //fim da fun��o cancelar voo
/*-------------------------------------------------------------------------------------------
 *                               VER OP��ES DE VOO
 * ------------------------------------------------------------------------------------------*/
    public static void OpcoesVoo(int i) {
        for (i = 0; i < empAerea.length; i++) {
            if (vaz[i]) {
                System.out.printf("\nCodigo do Voo: %s", codVoo[i]);
                System.out.printf("\nEmpresa aerea: %s", empAerea[i]);
                System.out.printf("\nNumero de lugares disponiveis: %d \n", dispL[i]);
            } //fim do if
        }
    } //fim da fun��o op��es de voo
/*-------------------------------------------------------------------------------------------
 *                           RESERVA DE PASSAGENS
 * ------------------------------------------------------------------------------------------*/
    public static void Reserva(int codV) {
       
        System.out.print("\nInforme o codigo do Voo:");
        codV = leia.nextInt();

   /*imprimir o n�mero da identidade do cliente, e o n�mero do v�o, atualizando
    *o n�mero de lugares dispon�veis**/
 
        if (dispL[codV - 1] > 0) {
            System.out.print("Informe o RG do passageiro:");
            RG[codV - 1] = leia.next();

            dispL[codV - 1] -= 1;
           
            System.out.printf("Reserva confirmada para %s no voo %s da Empresa %s\n\n",
                    RG[codV - 1], codVoo[codV - 1], empAerea[codV - 1]);
           
            RG[codV - 1]=""; //Zera este vetor
           
    //avisar ao cliente da inexist�ncia de lugares.
        } else {
            System.out.println("--------------------------------------------------------------\n"
                    + "N�o ha disponibilidade de vaga para este voo\n"
                    + "--------------------------------------------------------------");
        }
    } //fim da fun��o reserva
/*-------------------------------------------------------------------------------------------
 *                          VER RESERVA DE PASSAGENS
 * ------------------------------------------------------------------------------------------*/
    public static void VerReserva(int codV) {
        if (dispL[codV - 1] > 0) {
            System.out.printf("%d lugar(es) disponivel(is) para o voo %s da Empresa %s\n",
                    dispL[codV - 1], codVoo[codV - 1], empAerea[codV - 1]);
        } else {
            System.out.println("--------------------------------------------------------------\n"
                    + "N�o ha disponibilidade de vaga para este voo\n"
                    + "--------------------------------------------------------------");
        } //fim do else
    } //fim da fun��o ver Reservas
/*-------------------------------------------------------------------------------------------
 *                      CANCELAR RESERVA DE PASSAGENS
 * ------------------------------------------------------------------------------------------*/
    public static void CancelarRe(int codV) {
        if (dispL[codV - 1] < k[codV - 1]) {
                RG[codV - 1] = leia.next();
           
                //atualiza a disponibilidade de lugares
                dispL[codV - 1] += 1;
           
        } else {
            System.out.println("N�o ha reserva para este voo");
        }
        System.out.println("Opera��o realizada com sucesso!");
    } //fim da fun��o cancelar reserva   
} //fim da classe