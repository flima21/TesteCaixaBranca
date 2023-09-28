# TESTE DE CAIXA BRANCA - QUALIDADE E TESTES DE SOFTWARE

# DESCRIÇÃO
O repositório em questão tem como objetivo a simulação de um teste de caixa branca, cujo tem como objetivo o funcionamento interno do sistema, ou seja, uma análise diretamente relacionada ao código fonte do sistema a ser testado (GONÇALVEZ et al,2019), neste caso, a classe `User.java`.

# ESTRUTURA 
A classe User é um código escrito em Java e foi formulado e proposto na aula de Qualidade e Testes de Software para que seja evidenciado os problemas existentes no decorrer da leitura do mesmo. Caso haja a copia deste repositório é de extrema importância que o banco de dados o qual a classe tenta se conectar esteja criado, portanto, o arquivo `databasetqs.sql` deve ser executado anterior ao código.

1. `databasetqs.sql`: Composto por um script sql de criação do banco.
```
CREATE DATABASE test;
CREATE TABLE usuarios(login varchar(255) not null, senha varchar(255) not null);
```
2. `User.java`: Arquivo que contém a classe User e dentro desta os métodos a serem utilizados:
     1. `conectarBD`: Responsável por criar a string de conexão e tentar conectar ao banco de dados passado na string.
     2. `verificarUsuario`: Responsável por retornar se o usuário com a senha passadas por parâmetro existe na tabela de usuários.

# TESTES
Os testes foram por métodos e na execução macro da classe, ou seja, primeiramente foi testado o instanciamento da classe, o método `conectarBD()`, `verificarUsuario`,a execução do script por inteiro para verificar se havia comportamentos distintos quando os métodos eram implementados de maneira composta  e por fim a documentação.

### PRIMEIRO TESTE - INSTANCIAMENTO DA CLASSE 
Não foram identificados erros no momento de instanciar.

### SEGUNDO TESTE - `conectarBD`
1. Após diversas tentativas, ajustes do horário local foi visto que não é possível efetuar consulta no banco de dados devido a linha que contém a seguinte escrita `Class.forName("com.mysql.Driver.Manager").newInstance();`, os compiladores acusaram erro e só após pesquisas foi identificado que para possível correção seria interessante a troca do driver por `Class.forName("com.mysql.cj.jdbc.Driver").newInstance();`
2. O método apresenta uma estrutura de try catch, todavia, o catch encontra-se totalmente vazio e ao compilar foi apresentado erro, é de extrema importância haver pelo menos algum comentário ou retorno de mensagem para que o código seja compilado com exito.

### TERCEIRO TESTE - `verificarUsuario`
1. O método apresenta uma estrutura de try catch, todavia, o catch encontra-se totalmente vazio e ao compilar foi apresentado erro, é de extrema importância haver pelo menos algum comentário ou retorno de mensagem para que o código seja compilado com exito.
2. Após a consulta dos usuários ser retornada, não há um fechamento das transações, o que após diversas compilações, foram identificadas diversos conexões abertas no MySQL.
3. As nomenclaturas de variáveis podem ser alteradas para elucidar melhor o processo de manutenção, por exemplo, `nome para nome_usuario` e o `result para result_query`.
### QUARTO TESTE - DOCUMENTAÇÃO
1. Não há documentação que oriente a pessoa que irá manusear o código de forma rápida e explicativa, forçando os analistas a lerem o código de forma completa.
