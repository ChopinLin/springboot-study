package org.lxp.springboot.togglz;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static org.lxp.springboot.togglz.MyFeatures.FEATURE_ONE;

/**
 * Created by linxiaopeng on 2018-3-2.
 */
@RestController
@RequestMapping("/toggle")
public class TogglzController {

//    @Autowired
    private FeatureManager manager;

    public TogglzController(FeatureManager manager){
        this.manager = manager;
    }


    @GetMapping("/test1")
    public JSONObject test1() {
        JSONObject res = new JSONObject();

        if (manager.isActive(FEATURE_ONE)) {
            res.put("FEATURE_ONE","active");
        }else{
            res.put("FEATURE_ONE","inactive");
        }
        return res;
    }
}
