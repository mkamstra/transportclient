package nl.martijnkamstra.transport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
@WebAppConfiguration
public class TransportApplicationTests {

    @Test
    public void contextLoads() {}
}
