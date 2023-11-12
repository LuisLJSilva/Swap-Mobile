package br.edu.infnet.swapmobile;

import br.edu.infnet.swapmobile.model.domain.*;
import br.edu.infnet.swapmobile.model.service.OrdemDeTrocaService;
import br.edu.infnet.swapmobile.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrdemDeTrocaLoader implements ApplicationRunner {

    @Autowired
    private OrdemDeTrocaService ordemDeTrocaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Map<LocalDateTime, OrdemDeTroca> mapaOrdemDeTroca = new HashMap<LocalDateTime, OrdemDeTroca>();

        FileReader file = new FileReader("arquivos/ordemTrocaCliente.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        OrdemDeTroca ordemDeTroca = null;

        while(linha != null) {
            campos = linha.split(";");

            switch (campos[0]) {
                case "OT":

                    ordemDeTroca = new OrdemDeTroca(
                            campos[1],
                            new Cliente(Integer.valueOf(campos[2])),
                            new ArrayList<Troca>(),
                            new Usuario(1)
                    );

                    mapaOrdemDeTroca.put(ordemDeTroca.getDataAgendamento(), ordemDeTroca);

                    break;

                case "A":

                    ordemDeTroca.getTrocas().add(new Avaliacao(Integer.valueOf(campos[1])));

                    break;

                case "NT":


                    ordemDeTroca.getTrocas().add(new NovoTelefone (Integer.valueOf(campos[1])));

                    break;

                case "E":

                    ordemDeTroca.getTrocas().add(new Entrega (Integer.valueOf(campos[1])));

                    break;

                default:
                    break;
            }

            linha = leitura.readLine();
        }

        for(OrdemDeTroca ot : mapaOrdemDeTroca.values()) {
            ordemDeTrocaService.incluir(ot);
            System.out.println("[Ordem Servico] Inclusão realizada com sucesso: " + ot);
        }

        for(OrdemDeTroca ot : ordemDeTrocaService.obterLista()) {
            System.out.println("[Ordem Servico] Inclusão realizada com sucesso: " + ot);
        }


        leitura.close();
    }

}
