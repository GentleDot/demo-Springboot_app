package net.gentledot;/**
 * Created by Sang on 2017-04-27.
 */

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // @WebIntegrationTest 에서 변경 : 서버에서 테스트 실행
public class SimpleWebTest {
    @Value("${local.server.port}")
    private int port;

    @Test(expected = HttpClientErrorException.class)
    public void pageNotFound(){
        try {
            RestTemplate rest = new RestTemplate();

            // get 요청 수행
            rest.getForObject("http://localhost:{port}/bogusPage", String.class, port);
            fail("Should result in HTTP 404");
        } catch (HttpClientErrorException e){
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode()); // HTTP 코드 404 인지 검사
            throw e;
        }
    }

}