package th.ac.mahidol.ict.gemini6.Config;

import edu.gemini.app.ocs.controller.VirtualTelescopeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OcsConfig {
    @Bean
    public VirtualTelescopeHandler virtualTelescopeHandler() {
        return new VirtualTelescopeHandler();
    }
}