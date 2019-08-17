package com.springwebflux.projects.webprojects.repoTest.controllerTest;

import com.springwebflux.projects.webprojects.controller.WebManagementController;
import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.service.WebManagementService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

/**
 * Do not forget when you use @WebFluxTest it just about the web tier side not service or repo side
 * so you can use two option @SpringBootTest  start all application context or use @WebFluxTest with @MockBean and
 * Mocikto.when.thenReturn
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = WebManagementController.class)
@Slf4j
public class WebManagementControllerTest {

    private static WebManagement webManagement = new WebManagement(null, "John");
    @MockBean
    WebManagementService webManagementService;
    @Autowired
    private WebTestClient webTestClient;

    @Before
    public void initialzr() {
        // for webmanagement service create
        Mockito.when(webManagementService.create(webManagement))
                .thenReturn(Mono.just(new WebManagement("1", "Jackson")));

        // for webmanagement service return all
        Mockito.when(webManagementService.webManagements())
                .thenReturn(Flux.just(new WebManagement("1", "Jackson"),
                        new WebManagement("2", "Sara"),
                        new WebManagement("3", "Joe")));

        // for webmanagement service return just one
        Mockito.when(webManagementService.webManagements(any(String.class)))
                .thenReturn(Mono.just(webManagement));


        Mockito.when(webManagementService.deleteById(any(String.class)))
                .thenReturn(Mono.empty());
    }


    @Test
    public void inserBulkData() {
        WebManagement webManagements = webTestClient.post().uri("/webmanagement/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(webManagement))
                .exchange().expectBody(WebManagement.class).returnResult().getResponseBody();
        log.info(webManagements.getId() + webManagements.getName());
        Assert.assertEquals(webManagements.getName(), "John");
    }

    @Test
    public void get_all_web_managements() {
        List<WebManagement> webManagement = webTestClient.get().uri("/webmanagement/managements")
                .accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .exchange().expectStatus().isOk().expectBodyList(WebManagement.class).returnResult().getResponseBody();
        Assert.assertNotEquals(webManagement.size(), 0);
        Assert.assertEquals(webManagement.size(), 3);

    }

    @Test
    public void delete_one_element_by_id() {
        webTestClient.delete().uri("/webmanagement/delete/by/7") // or we can use something like this uriBuilder -> uriBuilder.path("/webmanagement/delete/by/{id}").build(5)
                .exchange().expectStatus().isOk().expectBody().isEmpty();
    }


    @Test
    public void delete_one_element_by_id_v2() {
        webTestClient.delete().uri("/webmanagement/delete/by/7") // or we can use something like this uriBuilder -> uriBuilder.path("/webmanagement/delete/by/{id}").build(5)
                .exchange().expectStatus().isOk().expectBody(Void.class);
    }
}
