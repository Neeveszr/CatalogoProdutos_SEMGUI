import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import redis.clients.jedis.Jedis;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private MongoCollection<Document> collection = MongoConnection.getDatabase().getCollection("produtos");
    private Jedis cache = RedisConnection.getConnection();

    // CRIAR PRODUTO
    public void criarProduto(Produto p) {
        Document doc = new Document("_id", p.getId())
                .append("nome", p.getNome())
                .append("preco", p.getPreco());
        collection.insertOne(doc);
        // DELETAR CACHE (REDIS) SEMPRE QUE CRIAR UM PRODUTO
        cache.del("lista_produtos");
        System.out.println("Produto cadastrado!");
    }

    // LISTAR PRODUTOS
    public void listarProdutos() {
    	//BUSCA O CACHE, CASO ENCONTRE DA PRINT NELE DIRETO SEM USAR O MONGODB
        String cached = cache.get("lista_produtos");
        if (cached != null) {
            System.out.println("(Cache Redis)");
            System.out.println(cached);
            return;
        }
        List<Document> produtos = collection.find().into(new ArrayList<>());
        StringBuilder sb = new StringBuilder();

        if (produtos.isEmpty()) {
            System.out.println(" Nenhum produto encontrado.");
            return;
        }

        sb.append("\n===  Lista de Produtos  ===\n");
        for (Document d : produtos) {
            String id = d.getString("_id");
            String nome = d.getString("nome");
            double preco = d.getDouble("preco");
            sb.append(" ID: ").append(id)
              .append(" | Nome: ").append(nome)
              .append(" | Preço: R$ ").append(preco)
              .append("\n");
        }

        String resultado = sb.toString();
        //CRIAÇÃO DO CACHE: 
        cache.set("lista_produtos", resultado);
        System.out.println(resultado);
    }

    // ATUALIZAR PRODUTOS
    public void atualizarProduto(String id, String novoNome, double novoPreco) {
        collection.updateOne(
                Filters.eq("_id", id),
                new Document("$set", new Document("nome", novoNome).append("preco", novoPreco))
        );
        // DELETAR CACHE SEMPRE QUE ATUALIZAR OS PRODUTOS!!
        cache.del("lista_produtos");
        System.out.println("Produto atualizado!");
    }

    // DELETAR PRODUTO
    public void deletarProduto(String id) {
        collection.deleteOne(Filters.eq("_id", id));
        // DELETAR CACHE SEMPRE QUE DELETAR OS PRODUTOS!
        cache.del("lista_produtos");
        System.out.println("❌ Produto removido!");
    }
}
