package br.edu.infnet.swapmobile;


import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Entrega;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.AvaliacaoService;
import br.edu.infnet.swapmobile.model.service.EntregaService;
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

@Order(4)
@Component
public class EntregaLoader implements ApplicationRunner {

    @Autowired
    private EntregaService entregaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/entrega.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Entrega entrega = new Entrega(
                    campos[0],
                    Float.valueOf(campos[1]),
                    Integer.valueOf(campos[2]),
                    Boolean.valueOf(campos[3]),
                    String.valueOf(campos[4]),
                    campos[5]);

            entrega.setUsuario(new Usuario(Integer.valueOf(campos[6])));

            entregaService.incluir(entrega);

            linha = leitura.readLine();

        }

        leitura.close();

    }

}