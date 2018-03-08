package org.lxp.springboot.togglz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;

/**
 * Created by linxiaopeng on 2018-3-5.
 */
@Configuration
public class TogglzJavaConfig {

    @Bean
    public FeatureManager buildManager(MyTogglzConfiguration myTogglzConfiguration){
        return new FeatureManagerBuilder()
                .togglzConfig(myTogglzConfiguration)
                .build();
    }
}
