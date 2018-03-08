package org.lxp.springboot.togglz;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;

@Component()
public class MyTogglzConfiguration implements TogglzConfig {

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }

    @Override
    public StateRepository getStateRepository() {
        return new InMemoryStateRepository();
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    }

}