package com.edatablock.rpaclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RpaJwtClient {

    // Inject via application.properties

    private final Logger log = LoggerFactory.getLogger(this.getClass());
        @Value("${URL_RPAPROJECT_LOGIN}")
       public  String URL_LOGIN;

    @Value("${URL_RPAPROJECT}")
         public String URL_RPAPROJECT;
        // POST Login
        // @return "Authorization string".
        public  String postLogin(String username, String password) {

            // Request Header
            HttpHeaders headers = new HttpHeaders();

            // Request Body
            //MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
            User user= new User(username,password);


            headers.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String userjson="";
            try {
                userjson = mapper.writeValueAsString(user);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // Request Entity
           // HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);
            HttpEntity<String> requestEntity = new HttpEntity<String>(userjson, headers);


            // RestTemplate
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            // POST Login
            System.out.println("---------------------URL-----"+URL_LOGIN+requestEntity.getBody()+requestEntity.getHeaders());
           // logRequest(requestEntity, requestEntity.getBody());
            ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN, //
                    HttpMethod.POST, requestEntity,String.class);

            HttpHeaders responseHeaders = response.getHeaders();

            List<String> list = responseHeaders.get("Authorization");
            return list == null || list.isEmpty() ? null : list.get(0);
        }

        public  void callRPARESTApi(String restUrl, String authorizationString) {
            // HttpHeaders
            HttpHeaders headers = new HttpHeaders();

            //
            // Authorization string (JWT)
            //
            headers.set("Authorization", authorizationString);
            //
            headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));

            // Request to return JSON format
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> params = new HashMap<String, String>();
            params.put("id", "1");
            URI uri = UriComponentsBuilder.fromUriString(URL_RPAPROJECT)
                    .buildAndExpand(params)
                    .toUri();

            // HttpEntity<String>: To get result as String.
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            // RestTemplate
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            // Send request with GET method, and Headers.
            ResponseEntity<String> response = restTemplate.exchange(uri.toString(), //
                    HttpMethod.GET, entity, String.class);

            String result = response.getBody();

            System.out.println("****************test------------------"+result);
        }


//
//    public  void createTemplate(String restUrl, String authorizationString, TemplateFields[] templateFields, Client client) {
//        // HttpHeaders
//        HttpHeaders headers = new HttpHeaders();
//
//        //
//        // Authorization string (JWT)
//        //
//        headers.set("Authorization", authorizationString);
//        //
//        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//
//        // Request to return JSON format
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id", "1");
//        URI uri = UriComponentsBuilder.fromUriString(URL_RPAPROJECT)
//                .buildAndExpand(params)
//                .toUri();
//
//        // HttpEntity<String>: To get result as String.
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        // RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        // Send request with GET method, and Headers.
//        ResponseEntity<String> response = restTemplate.exchange(uri.toString(), //
//                HttpMethod.GET, entity, String.class);
//
//        String result = response.getBody();
//
//        System.out.println("****************test------------------"+result);
//    }







}
