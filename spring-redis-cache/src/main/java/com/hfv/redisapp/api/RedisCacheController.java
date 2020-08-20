package com.hfv.redisapp.api;

import com.hfv.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redistest")
public class RedisCacheController {

    private int counter = 0;

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException{

        if (counter == 5)
        {
            redisCacheService.clearCache();
        }

        counter ++;
        return redisCacheService.longRunningMethod();
    }
}
