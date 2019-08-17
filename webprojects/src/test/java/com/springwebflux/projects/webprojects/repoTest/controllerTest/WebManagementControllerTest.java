package com.springwebflux.projects.webprojects.repoTest.controllerTest;

import com.springwebflux.projects.webprojects.controller.WebManagementController;
import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.service.WebManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;

import java.util.List;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = WebManagementController.class)
@Slf4j
public class WebManagementControllerTest {

    @Autowired
    private  WebTestClient webTestClient;

    @MockBean
    WebManagementService webManagementService;

    @Test
    public void inserBulkData() {
        WebManagement webManagements = webTestClient.post().uri("/webmanagement/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(new WebManagement(null,"John")))
                .exchange().expectBody(WebManagement.class).returnResult().getResponseBody();

        Assert.assertEquals(webManagements.getName(),"John");
    }

    @Test
    public void get_all_web_managements() {
        List<WebManagement> webManagement = webTestClient.get().uri("/webmanagement/managements")
                .accept(MediaType.APPLICATION_JSON)
                .header("Content-Type","application/json")
                .exchange().expectStatus().isOk().expectBodyList(WebManagement.class).returnResult().getResponseBody();
        Assert.assertNotEquals(webManagement.size(),0);

    }

}
