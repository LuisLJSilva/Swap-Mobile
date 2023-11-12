package br.edu.infnet.swapmobile;


import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Cliente;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.AvaliacaoService;
import br.edu.infnet.swapmobile.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class AvaliacaoLoader implements ApplicationRunner {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/avaliacao.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Avaliacao avaliacao = new Avaliacao(
                    campos[0],
                    Float.valueOf(campos[1]),
                    Integer.valueOf(campos[2]),
                    String.valueOf(campos[3]),
                    Float.valueOf(campos[4]),
                    campos[5]);

            avaliacao.setUsuario(new Usuario(Integer.valueOf(campos[6])));

            avaliacaoService.incluir(avaliacao);

            linha = leitura.readLine();

        }

        leitura.close();

    }

}