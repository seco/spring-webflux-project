package com.springwebflux.projects.webprojects.repoTest.controllerTest;

import com.springwebflux.projects.webprojects.WebprojectsApplication;
import com.springwebflux.projects.webprojects.entities.WebManagement;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebprojectsApplication.class)
@Slf4j
public class WebManagementBindServerControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    // TODO : doesnt work ! 
    @Test
    public void inserBulkDataV2() {
        WebManagement webManagement = new WebManagement(null, "Jackson");
        WebManagement savedWebManagement = webTestClient.post().uri("/webmanagement/lets/V2").contentType(MediaType.APPLICATION_JSON).
                body(BodyInserters.fromObject(webManagement)).exchange().expectStatus().isOk().
                expectBody(WebManagement.class).returnResult().getResponseBody();
        Assert.assertEquals(savedWebManagement.getName(), webManagement.getName());
    }
}
