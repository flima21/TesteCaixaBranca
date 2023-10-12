import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * User é a classe de representação de usuários existentes dentro da aplicação 
 */
public class User {
    /**
     * Representação do nome do usuario.
     */
    public String nome = "";
    /**
     * Variavel representa para identificação do retorno do banco de dados, utilizada para identificação de existência
     */
    public boolean result = false;


    /**
     * Estabelece conexão com o banco de dados
     * 
     * @return o objeto de conexão do banco de dados.
     * @throws Exception mensagem de falha na conexão
     */
    public Connection conectarBD(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.Driver.Manager").newInstance(); // Carregamento do JDBC para estabelecer conexões entre JAVA E MYSQL

            /*
              Informações para conectar com o banco de dados na string são obrigatórias
              
              1. Ip: Neste caso representado por 127.0.0.1
              2. Database: Neste caso representado por test
              3. User: Root
              4. Password: Fe210802DBA.

              Essas informações devem ser adequadas mediante aos seus acessos
            */

            String url = "jdbc:mysql://127.0.0.1/test?user=root&password=Fe210802DBA."; 
            conn = DriverManager.getConnection(url); // Estabelece a conexão com o serviço de dados.
        }catch(Exception e){
          // Em caso de falha, realizar o tratamento do erro
        }
        return conn; // Retorno do objeto de conexão
    }

    /**
     * Verificação da existência do usuário dentro do Banco de dados
     * 
     * @param login O login de acesso a aplicação 
     * @param senha A senha de acesso a aplicação
     * 
     * @return booleano identificando se há ou não o usuário, em caso verdadeiro é True.
     * @throws Exception mensagem de execução falha
     */
    public boolean verificarUsuario(String login,String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Instanciamento do Connection a partir da chamada de funçáo conectarBD()

        //INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement(); // Criação do objeto para envio da instrução SQL
            ResultSet rs = st.executeQuery(sql); // Envio da instrução SQL vinda da concatenação da variavel sql

            // Caso haja objetos dentro do retorno
            if(rs.next()){
                result = true; 
                nome = rs.getString("nome"); // Atribuição da propriedade nome a variavel nome
            }
        }catch (Exception e) {
          // Em caso de falha, realizar o tratamento do erro
        }

        return result;
    }
} // fim da classe
