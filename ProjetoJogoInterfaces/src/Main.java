import com.github.henriquefdesouza.jogo.Jogo;
import com.github.henriquefdesouza.nivel.NivelFacil;
import com.github.henriquefdesouza.nivel.NivelInvalidoException;
import com.github.henriquefdesouza.usuario.Usuario;

public class Main {


    public static void main(String[] args) {

        try {
            Usuario usuario = new Usuario("Henrique");

            /**
             * se desejar pode instanciar um nivel e passar ele como
             * argumento no jogo e assim iniciar o game direto no nivel instanciado
             * ou apenas da start com o usuario.
             */
            NivelFacil nivelFacil = new NivelFacil();

            Jogo novoJogo = new Jogo(usuario);
            novoJogo.startGame();
        } catch (NivelInvalidoException e) {
            System.out.println("Erro Nivel: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Erro Usuario: " + e.getMessage());
        }


    }
}