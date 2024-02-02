package guru.springframework.mssc.msscbreweryclient.web.client;

import guru.springframework.mssc.msscbreweryclient.web.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false )
@Component
public class BreweryClient {
    private String apihost;
    public final String  BEER_PATH = "/api/v1/beer/";
    private RestTemplate restTemplate;
    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    public BeerDTO getBeerById(UUID uuid){
        return  this.restTemplate.getForObject(apihost + BEER_PATH + uuid.toString() ,BeerDTO.class);
    }
    public BeerDTO saveBeer(BeerDTO beerDTO){
        return this.restTemplate.postForObject(apihost + BEER_PATH ,beerDTO,BeerDTO.class);
    }
    public void updateBeer(UUID id, BeerDTO beerDTO){
        this.restTemplate.put(apihost + BEER_PATH + id.toString(),beerDTO);
    }
    public String getApihost() {
        return apihost;
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
