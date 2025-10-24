import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner sc = new Scanner(System.in);

       // PRINTS DO MENU
        while (true) {
            System.out.println("\n=== CATÁLOGO DE PRODUTOS ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = sc.nextInt();
            sc.nextLine();

            // SWITCH CASES DE CADA OPÇÃO DO MENU
            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    dao.criarProduto(new Produto(id, nome, preco));
                    break;
                case 2:
                    dao.listarProdutos();
                    break;
                case 3:
                    System.out.print("ID: ");
                    String idUp = sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = sc.nextDouble();
                    dao.atualizarProduto(idUp, novoNome, novoPreco);
                    break;
                case 4:
                    System.out.print("ID: ");
                    String idDel = sc.nextLine();
                    dao.deletarProduto(idDel);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
