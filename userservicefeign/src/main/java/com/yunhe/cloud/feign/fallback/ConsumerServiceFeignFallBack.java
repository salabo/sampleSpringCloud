package com.yunhe.cloud.feign.fallback;

import com.yunhe.cloud.entities.Consumer;
import com.yunhe.cloud.feign.ConsumerServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceFeignFallBack implements ConsumerServiceFeign {
    @Override
    public Consumer getById(Integer id) {
        return new Consumer("zhangbo",123);
    }
}
