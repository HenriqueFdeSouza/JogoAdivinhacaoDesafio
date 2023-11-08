import com.github.henriquefdesouza.jogo.Jogo;
import com.github.henriquefdesouza.nivel.Nivel;
import com.github.henriquefdesouza.nivel.NivelFacil;
import com.github.henriquefdesouza.excecoes.NivelInvalidoException;
import com.github.henriquefdesouza.usuario.Usuario;

public class Main {


    public static void main(String[] args) {
        /**
         * se desejar pode instanciar um nivel e passar ele como
         * argumento no jogo e assim iniciar o game direto no nivel instanciado
         * ou apenas da start com o usuario e escolher no Menu.
         */

        Usuario usuario = new Usuario("Henrique");

        NivelFacil nivelFacil = new NivelFacil();

        Jogo novoJogo = new Jogo(null);
        novoJogo.startGame();

    }
}