import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = null;
        String sobrenome = null;
        String senha = null;
        boolean cadastrado = false;

        while (true) {
            System.out.println("\nEstá em fase de testes.");
            System.out.println("1. Inserir nome e sobrenome");
            System.out.println("2. Criar senha manualmente");
            System.out.println("3. Criar senha automaticamente");
            System.out.println("4. Editar nome ou sobrenome");
            System.out.println("5. Mostrar dados cadastrados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Vai consumir linha após o nextInt()

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome e sobrenome (separados por espaço): ");
                    String[] partesNome = scanner.nextLine().split(" ");
                    if (partesNome.length >= 2) {
                        nome = partesNome[0];
                        sobrenome = partesNome[1];
                        cadastrado = true;
                        System.out.println("Nome e sobrenome cadastrados com sucesso!");
                    } else {
                        System.out.println("Formato inválido. Tente novamente.");
                    }
                    break;
                case 2:
                    if (cadastrado) {
                        System.out.print("Digite a senha desejada: ");
                        String senha1 = scanner.nextLine();
                        System.out.print("Digite novamente a senha: ");
                        String senha2 = scanner.nextLine();

                        if (senha1.equals(senha2) && senha1.length() >= 8 && senha1.charAt(3) == 'Z') {
                            senha = senha1;
                            System.out.println("Senha criada e armazenada com sucesso!");
                        } else {
                            System.out.println("As senhas não coincidem ou não atendem aos requisitos.");
                        }
                    } else {
                        System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
                    }
                    break;
                case 3:
                    if (cadastrado) {
                        String senhaAutomatica = (nome.substring(0, Math.min(nome.length(), 4)).toUpperCase() +
                                sobrenome.substring(Math.max(sobrenome.length() - 4, 0)).toUpperCase());
                        senha = senhaAutomatica;
                        System.out.println("Senha automática gerada e armazenada: " + senhaAutomatica);
                    } else {
                        System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
                    }
                    break;
                case 4:
                    if (cadastrado) {
                        System.out.print("Digite o novo nome e sobrenome (separados por espaço): ");
                        String[] novasPartesNome = scanner.nextLine().split(" ");
                        if (novasPartesNome.length >= 2) {
                            nome = novasPartesNome[0];
                            sobrenome = novasPartesNome[1];
                            System.out.println("Nome e sobrenome editados com sucesso!");
                        } else {
                            System.out.println("Formato inválido. Tente novamente.");
                        }
                    } else {
                        System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
                    }
                    break;
                case 5:
                    if (cadastrado) {
                        System.out.println("\n===== Dados Cadastrados =====");
                        System.out.println("Nome: " + nome);
                        System.out.println("Sobrenome: " + sobrenome);
                        System.out.println("Senha: " + senha);
                    } else {
                        System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa, obrigado por testar...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}