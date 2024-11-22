import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CotacaoService {
    public Double buscaCotacao(String moeda,String moedaCotacao) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/**APIKEY**/latest/" + moedaCotacao.trim().toLowerCase());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            // Envia a requisição e recebe a resposta
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Loga o conteúdo da resposta para inspeção
//            System.out.println("Resposta da API: " + response.body());

            // Cria o JsonReader no modo leniente para evitar erro de parsing
            JsonReader reader = new JsonReader(new StringReader(response.body()));
            reader.setLenient(true);

            // Analisa o JSON retornado
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Acessa o objeto "conversion_rates"
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Obtém o valor da moeda solicitada
            if (conversionRates.has(moeda)) {
                return conversionRates.get(moeda).getAsDouble();
            } else {
                throw new RuntimeException("Moeda não encontrada.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a cotação: " + e.getMessage());
        }
    }
}
