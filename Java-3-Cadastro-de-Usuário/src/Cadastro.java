import java.util.Scanner;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    String nome, senha;
    void inserirNome(){
        System.out.println("Por favor, digite seu nome e sobrenome");
        this.nome = scanner.nextLine().replace(" ","");
        System.out.println("Seja bem vindo(a), " + nome);
    }

    void criarSenhaManual(){
        if(nome == null){
            System.out.println("Por favor, seleciona a opção para cadastrar nome e sobrenome antes de criar senha");
            return;
        }
        System.out.println("Crie uma senha: ");
        String senha1 = scanner.nextLine();
        System.out.println("Digite a senha novamente: ");
        String senha2 = scanner.nextLine();
        if(!senha1.equals(senha2)){
            System.out.println("As senhas não coincidem");
            return;
        }
        if(senha1.length()<8){
            System.out.println("A senha deve ter pelo menos 8 caracteres");
            return;
        }

        // Colocando a letra 'Z' na quarta posição da senha
        if (senha1.charAt(3)!='Z'){
            System.out.println("A senha deve ter Z na quarta posição");
            return;
        }
        this.senha = senha1;
        System.out.println("Sua nova senha é: "+ senha);
    }

    void criarSenhaAutomatica(){
        if(nome == null){
            System.out.println("Por favor, seleciona a opção para cadastrar nome e sobrenome antes de criar senha");
            return;
        }
        this.senha= nome.substring(0,4).concat(nome.substring(nome.length()-4));
        System.out.println("Sua nova senha é "+ senha);
    }

    void editNome(){
        System.out.println("Digite o nome ou sobrenome que será alterado: ");
        String nomeOriginal = scanner.nextLine();
        System.out.println("Digite o novo valor: ");
        String nomeAtualizado = scanner.nextLine();
        this.nome = nome.replace(nomeOriginal, nomeAtualizado);
        System.out.println("O nome "+ nomeOriginal+ " foi atualizado para " + nomeAtualizado);
        System.out.println("Esse é o novo nome completo: "+ nomeAtualizado);
    }
    void menuCadastro(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Cadastrar nome e sobrenome");
        System.out.println("2- Criar senha manualmente");
        System.out.println("3- Criar senha automaticamente");
        System.out.println("4- Editar nome ou sobrenome");
        System.out.println("5- Sair");
    }
}