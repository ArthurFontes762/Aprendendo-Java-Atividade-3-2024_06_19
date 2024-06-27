public class User {
    private String nome;
    private String sobrenome;
    private String senha;

    public void cadastrarDados(String nome, String sobrenome, String senha) {
        if (nome != null && sobrenome != null) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.senha = senha;
            System.out.println("Dados cadastrados com sucesso!");
        } else {
            System.out.println("Nome e sobrenome não podem ser nulos.");
        }
    }

    public boolean validarSenhaManual(String senha) {
        return this.senha != null && this.senha.equals(senha);
    }

    public String gerarSenhaAutomatica() {
        if (nome != null && sobrenome != null) {
            return (nome.substring(0, Math.min(nome.length(), 4)).toUpperCase() +
                    sobrenome.substring(Math.max(sobrenome.length() - 4, 0)).toUpperCase());
        }
        return null;
    }

    public void editarDados(String nome, String sobrenome) {
        if (this.nome != null && this.sobrenome != null) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            System.out.println("Dados editados com sucesso!");
        } else {
            System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
        }
    }

    public void mostrarDados() {
        if (nome != null && sobrenome != null) {
            System.out.println("\n===== Dados Cadastrados =====");
            System.out.println("Nome: " + nome);
            System.out.println("Sobrenome: " + sobrenome);
            System.out.println("Senha: " + senha); // Não exibir diretamente a senha
        } else {
            System.out.println("Por favor, cadastre o nome e sobrenome primeiro.");
        }
    }
}