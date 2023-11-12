package br.edu.infnet.swapmobile;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Entrega;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.TrocaService;
import br.edu.infnet.swapmobile.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Order(3)
@Component
public class TrocaLoader implements ApplicationRunner {

    @Autowired
    private TrocaService trocaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/troca.txt");
        BufferedReader leitura = new BufferedReader(file);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            switch (campos[7]) {

                case "A":

                    Avaliacao avaliacao = new Avaliacao(
                            campos[0],
                            Float.valueOf(campos[1]),
                            Integer.valueOf(campos[2]),
                            String.valueOf(campos[3]),
                            Float.valueOf(campos[4]),
                            campos[5]);

                    avaliacao.setUsuario(new Usuario(Integer.valueOf(campos[6])));

                    trocaService.incluir(avaliacao);

                    break;

                case "N":

                    NovoTelefone novoTelefone = new NovoTelefone(
                            campos[0],
                            Float.valueOf(campos[1]),
                            Integer.valueOf(campos[2]),
                            String.valueOf(campos[3]),
                            Float.valueOf(campos[4]),
                            campos[5]);

                    novoTelefone.setUsuario(new Usuario(Integer.valueOf(campos[6])));

                    trocaService.incluir(novoTelefone);

                    break;

                case "E":


                    Entrega entrega = new Entrega(
                            campos[0],
                            Float.valueOf(campos[1]),
                            Integer.valueOf(campos[2]),
                            Boolean.valueOf(campos[3]),
                            String.valueOf(campos[4]),
                            campos[5]);

                    entrega.setUsuario(new Usuario(Integer.valueOf(campos[6])));

                    trocaService.incluir(entrega);

                    break;



                default:
                    break;
            }

            linha = leitura.readLine();
        }

        leitura.close();
    }

}
