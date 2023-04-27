import java.util.Scanner;
//Aluna: Bruna Eduarda Mariano Wnuk

public class ImpostoDeRenda {
    public static void main (String [] args ){
        Scanner scanner = new Scanner (System.in);

        String nome = "";
        String cpf = "";
        String email = "";
        String dataNasc = "";
        String telefone = "";
        double salario = 0;
        double inss = 0.0;
        double irpf = 0.0;
        double anualInss = 0;
        double anualIrpf = 0;
        String NomeDoMes = "";

        System.out.print("Olá! Irei te auxiliar no calculo do seu IRPF (Imposto de Renda Pessoa Física)." + 
        "Mas antes preciso realizar o seu cadastro. Informe seus dados pessoais:\n");

        do{
            System.out.print("\nNome Completo: ");
            nome = scanner.nextLine();

            System.out.print("\nCPF (xxx.xxx.xxx-xx): ");
            cpf = scanner.nextLine();
    
            System.out.print("\nE-mail: ");
            email = scanner.nextLine();
    
            System.out.print("\nData de Nascimento (dd/mm/yy): ");
            dataNasc = scanner.nextLine();

            System.out.print("\nTelefone ((DD)xxxxx-xxxx): ");
            telefone = scanner.nextLine();


            if (nome.isEmpty()||cpf.isEmpty()||email.isEmpty()||dataNasc.isEmpty()||telefone.isEmpty()){
                
                System.out.println("--------------------------------------------");
                System.out.println("Preencha todas as informações necessarias!");
                System.out.println("--------------------------------------------");
            }

        }while(nome.isEmpty()||cpf.isEmpty()||email.isEmpty()||dataNasc.isEmpty()||telefone.isEmpty());
            
                System.out.println("Cadastro realizado com sucesso!");

       
        for (int mes = 1; mes <= 12; mes++) {

            switch (mes) {
                case 1:
                    NomeDoMes = "Janeiro";
                    break;
                case 2:
                    NomeDoMes = "Fevereiro";
                    break;
                case 3: 
                    NomeDoMes = "Março";
                    break;
                case 4:
                    NomeDoMes = "Abril";
                    break;
                case 5:
                    NomeDoMes = "Maio";
                    break;
                case 6:
                    NomeDoMes = "Junho";
                    break;
                case 7:
                    NomeDoMes = "Julho";
                    break;
                case 8:
                    NomeDoMes = "Agosto";
                    break;
                case 9:
                    NomeDoMes = "Setembro";
                    break;
                case 10:
                    NomeDoMes = "Outubro";
                    break;
                case 11:
                    NomeDoMes = "Novembro";
                    break;
                case 12:
                    NomeDoMes = "Dezembro";
                    break;

                default:
                    NomeDoMes = "Mês inválido";
                    break;
}

        System.out.println("\nInforme o seu salário de " + NomeDoMes + ":");
        salario = scanner.nextDouble();

        if (salario <= 1302) {
            inss = salario * 0.075;
        } else if (salario <= 2571.29) {
            inss = salario * 0.09 - 19.53;
        } else if (salario <= 3856.94) {
            inss = salario * 0.12 - 96.67;
        } else if (salario <= 7507.49) {
            inss = salario * 0.14 - 173.80;
        } else {
            inss = 1501.50;
        }
  /* O maior desconto é sobre o teto de R$ 7.507,49. 
  Em 2023 esse valor pode chegar a R$ 1.501,50 para contribuintes com alíquota de 20%,  
  mesmo a receita ou salário sendo superior a esse valor. - Contabilizei.blog*/

        anualInss += inss;

        double baseIrpf = salario - inss;
            if (baseIrpf <= 1903.98) {
                irpf = 0.0;
            } else if (baseIrpf <= 2826.65) {
                irpf = baseIrpf * 0.075 - 142.80;
            } else if (baseIrpf <= 3751.05) {
                irpf = baseIrpf * 0.15 - 354.80;
            } else if (baseIrpf <= 4664.68) {
                irpf = baseIrpf * 0.225 - 636.13;
            } else {
                irpf = baseIrpf * 0.275 - 869.36;
            }
        
        anualIrpf += irpf;

        System.out.printf("INSS de " + NomeDoMes + ": R$" + "%.2f", inss);
        System.out.printf("\nIRPF de " + NomeDoMes + ": R$" + "%.2f\n", irpf);


}
        System.out.println("--------------------------------------------------");
        System.out.println("Nome:"+ nome);
        System.out.println("CPF:"+ cpf);
        System.out.println("E-mail:"+ email);
        System.out.println("Data de Nascimento:"+ dataNasc);
        System.out.println("Telefone:"+ telefone);

        System.out.println("\nAcumulado anual do INSS: R$ " + anualInss);
        System.out.println("Acumulado anual do IRPF: R$ " + anualIrpf);
        System.out.println("--------------------------------------------------");

    scanner.close();
    }
}

