package br.edu.infnet.swapmobile;


import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Cliente;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.AvaliacaoService;
import br.edu.infnet.swapmobile.model.service.ClienteService;
import br.edu.infnet.swapmobile.model.service.NovoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(5)
@Component
public class NovoTelefoneLoader implements ApplicationRunner {

    @Autowired
    private NovoTelefoneService novoTelefoneService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/novotelefone.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            NovoTelefone novoTelefone = new NovoTelefone(
                    campos[0],
                    Float.valueOf(campos[1]),
                    Integer.valueOf(campos[2]),
                    String.valueOf(campos[3]),
                    Float.valueOf(campos[4]),
                    campos[5]);

            novoTelefone.setUsuario(new Usuario(Integer.valueOf(campos[6])));

            novoTelefoneService.incluir(novoTelefone);

            linha = leitura.readLine();

        }

        leitura.close();

    }

}