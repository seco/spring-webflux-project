package com.springreact.projects.webprojects.repoTest.controllerTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebprojectsApplication.class)
@Slf4j
public class WebManagementBindServerControllerTest {

//    @Autowired
//    private WebTestClient webTestClient;

    // TODO : doesnt work ! 
//    @Test
//    public void inserBulkDataV2() {
//        WebManagement webManagement = new WebManagement(null, "Jackson");
//        WebManagement savedWebManagement = webTestClient.post().uri("/webmanagement/lets/V2").contentType(MediaType.APPLICATION_JSON).
//                body(BodyInserters.fromObject(webManagement)).exchange().expectStatus().isOk().
//                expectBody(WebManagement.class).returnResult().getResponseBody();
//        Assert.assertEquals(savedWebManagement.getName(), webManagement.getName());
//    }

    @Test
    public void lefted_empty(){

    }
}
