import java.util.Scanner;

public class UserService {
    private final User usuario;
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.usuario = new User();
        this.scanner = scanner;
    }

    public void inserirNomeSobrenome() {
        System.out.print("Digite o nome e sobrenome (separados por espaço): ");
        String[] partesNome = scanner.nextLine().split(" ");
        if (partesNome.length >= 2) {
            usuario.cadastrarDados(partesNome[0], partesNome[1], null); // Senha inicialmente nula
        } else {
            System.out.println("Formato inválido. Tente novamente.");
        }
    }

    public void criarSenhaManual() {
        if (usuario.validarSenhaManual(usuario.gerarSenhaAutomatica())) {
            System.out.print("Digite a senha desejada: ");
            String senha1 = scanner.nextLine();
            System.out.print("Digite novamente a senha: ");
            String senha2 = scanner.nextLine();

            if (senha1.equals(senha2) && senha1.length() >= 8 && senha1.charAt(3) == 'Z') {
                usuario.cadastrarDados(usuario.gerarSenhaAutomatica(), usuario.gerarSenhaAutomatica(), senha1);
                System.out.println("Senha criada e armazenada com sucesso!");
            } else {
                System.out.println("As senhas não coincidem ou não atendem aos requisitos.");
            }
        } else {
            System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
        }
    }

    public void criarSenhaAutomatica() {
        String senhaAutomatica = usuario.gerarSenhaAutomatica();
        if (senhaAutomatica != null) {
            usuario.cadastrarDados(usuario.gerarSenhaAutomatica(), usuario.gerarSenhaAutomatica(), senhaAutomatica);
            System.out.println("Senha automática gerada e armazenada: " + senhaAutomatica);
        } else {
            System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
        }
    }

    public void editarNomeSobrenome() {
        System.out.print("Digite o novo nome e sobrenome (separados por espaço): ");
        String[] novasPartesNome = scanner.nextLine().split(" ");
        if (novasPartesNome.length >= 2) {
            usuario.editarDados(novasPartesNome[0], novasPartesNome[1]);
        } else {
            System.out.println("Formato inválido. Tente novamente.");
        }
    }

    public void mostrarDados() {
        usuario.mostrarDados();
    }
}