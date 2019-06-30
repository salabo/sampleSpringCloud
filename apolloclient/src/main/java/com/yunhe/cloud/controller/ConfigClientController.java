package com.yunhe.cloud.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cfg")
@RefreshScope
public class ConfigClientController {

    @Value("${config_info}")
    private String config;


    @GetMapping("/cg")
    public String apploConfig(){
        Config config = ConfigService.getAppConfig();
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                for (String key : changeEvent.changedKeys()) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.println(String.format(
                            "Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s",
                            change.getPropertyName(), change.getOldValue(),
                            change.getNewValue(), change.getChangeType()));
                }
            }
        });
        return config.toString();
    }

    @RequestMapping
    public String getConfigInfo(){
        return config;
    }
}
