# 🛒 Catálogo de Produtos (Java + MongoDB + Redis)

Este projeto é um **sistema simples de Catálogo de Produtos** desenvolvido em **Java**, utilizando o **MongoDB Atlas** como banco de dados principal e o **Redis** como cache para otimizar as consultas.

O sistema permite **cadastrar, listar, atualizar e excluir produtos**, tudo via console.  
Ideal para quem está aprendendo integração entre Java e bancos NoSQL.

Video explicando o projeto! https://www.youtube.com/watch?v=mR1aK8BKOkc

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java**
- 🍃 **MongoDB Atlas** – banco de dados principal (armazenamento de produtos)
- 🔥 **Redis** – cache para otimização das consultas
---

## 🧱 Estrutura do Projeto
src/
├── Produto.java # Classe modelo (atributos, getters, setters, construtor)
├── ProdutoDAO.java # Classe de acesso ao banco (CRUD no MongoDB + Redis)
├── MongoConnection.java # Gerencia a conexão com o MongoDB Atlas
├── RedisConnection.java # Gerencia a conexão com o Redis
└──  Main.java # Main do código, com print do menu e case para seleção de opção! (CRUD pelo terminal)


## ⚙️ Funcionalidades

- ✅ **Cadastrar Produto** (inserir no MongoDB)
- 📜 **Listar Produtos** (com cache Redis opcional)
- ✏️ **Atualizar Produto** (nome e preço)
- ❌ **Excluir Produto** (por ID)
- 💾 **Armazenamento no MongoDB Atlas**
- ⚡ **Cache no Redis** (para evitar consultas repetidas)

## 🗄️ Exemplo de Uso (Console)
--- MENU ---
1. Cadastrar produto
2. Listar produtos
3. Atualizar produto
4. Excluir produto
5. Sair

Digite o ID: 01
Digite o nome: Teclado Mecânico
Digite o preço: 250.00
Produto cadastrado com sucesso!

## 🧰 Como Executar o Projeto
1. Baixe as dependências:
Adicione os JARs do MongoDB Driver e do Redis Jedis ao classpath do seu projeto no Eclipse.
Exemplos:
mongodb-driver-sync-4.x.jar
bson-4.x.jar
jedis-5.x.jar

2. Configure o MongoDB Atlas:
Crie um cluster em MongoDB Atlas
Copie sua Connection String (exemplo):
mongodb+srv://usuario:senha@cluster0.mongodb.net/?retryWrites=true&w=majority
Coloque essa URL no seu arquivo MongoConnection.java.

3. Configure o Redis (opcional):
Instale localmente com:
redis-server
Ou use um serviço online (como Redis Cloud).
Configure o host e a porta em RedisConnection.java.

4. Execute o programa:
Via console: Main.java

| Conceito            | Descrição                                                                |
| ------------------- | ------------------------------------------------------------------------ |
| **Construtor**      | Método especial que cria o objeto e define seus valores iniciais.        |
| **Getters/Setters** | Métodos para acessar e modificar os atributos privados.                  |
| **toString()**      | Retorna uma string legível representando o objeto.                       |
| **MongoDB Atlas**   | Armazena os dados de forma persistente na nuvem.                         |
| **Redis**           | Guarda informações temporárias em memória (cache), acelerando o sistema. |

## 🧾 Licença
Este projeto é de uso educacional e livre.
Sinta-se à vontade para estudar, modificar e compartilhar. 💙
