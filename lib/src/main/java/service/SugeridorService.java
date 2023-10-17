package service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SugeridorService {
	private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<String> obtenerSugerencias(List<String> products){
        String url = "https://recomendador-de-productos-production.up.railway.app/api/v1/recomendador/productosSugeridos";
        String json;
		try {
			json = mapper.writeValueAsString(products);
		} catch (JsonProcessingException e1) {
			return null;
		}
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Arrays.asList(mapper.readValue(response.body().string(), String[].class));
        }
        catch(Exception e) {
        	return null;
        }
    }
}
