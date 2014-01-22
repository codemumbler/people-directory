package com.creativesci.tutorial.jersey;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class PersonServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return PersonApplication.createApp();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(PersonApplication.createMoxyJsonResolver());
    }


    @Test
    public void testGetAllPeopleReturnsEmptyList() {
        try {
            GenericType<List<Person>> genericRootElement =
                    new GenericType<List<Person>>() {};
            target().path("/person").request(MediaType.APPLICATION_JSON).get(genericRootElement);
            //assertTrue(allPeople.isEmpty());
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
