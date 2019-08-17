package com.springwebflux.projects.webprojects;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.repo.WebManagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

@RunWith(SpringRunner.class)
@DataMongoTest
@Slf4j
public class WebManagementsRepoTest {

    @Autowired
    private WebManagementRepository webManagementRepository;

    @Test
    public void createWebManagement() {
        WebManagement webManagement = new WebManagement(null, "Jane");
        Mono<WebManagement> save = this.webManagementRepository.deleteAll().then(this.webManagementRepository.save(webManagement));
        StepVerifier
                .create(save)
                .expectNextMatches(webManagement1 -> webManagement1.getName().equals("Jane") && webManagement1.getId() != null)
                .verifyComplete();


    }


    @Test
    public void findAllAndCheckCount() {
        WebManagement webManagement = new WebManagement(null, "Jane");
        Flux<WebManagement> save = this.webManagementRepository.deleteAll().thenMany(this.webManagementRepository.saveAll(
                Flux.just(new WebManagement(null, "jane"),
                        new WebManagement(null, "Mike"),
                        new WebManagement(null, "Joe")
                ))).thenMany(this.webManagementRepository.findAll());


        StepVerifier
                .create(save)
                .expectNextCount(3)
                .verifyComplete();

    }


    @Test
    public void save_And_Delete() {
        WebManagement webManagement = new WebManagement(null, "Jane");
        Mono<Void> saved = this.webManagementRepository
                .deleteAll()
                .then(this.webManagementRepository.save(webManagement))
                .thenMany(this.webManagementRepository.findAll())
                .then(this.webManagementRepository.deleteAll());

        Duration duration = StepVerifier
                .create(saved)
                .expectNextCount(0)
                .verifyComplete();
        log.info("saving takes : " + duration);
    }

    @Test
    public void find_delete(){
        WebManagement webManagement = new WebManagement(null, "Jane");
        Mono<WebManagement> saved = this.webManagementRepository
                .deleteAll()
                .then(this.webManagementRepository.save(webManagement));

            Mono<Void> deleted = this.webManagementRepository.deleteById(saved.map(e->e.getId()));

            StepVerifier.create(saved).expectNextCount(1).verifyComplete();

            StepVerifier.create(deleted).expectNextCount(0).verifyComplete();
    }
}
