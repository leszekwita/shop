package com.radzik.michal.shop.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import com.radzik.michal.shop.domain.dao.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

   @Bean
    public Config configHazelcast() {
        Config config = new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig()
                        .setName("product")
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(3)
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                        ).setTimeToLiveSeconds(120));
        config.getNetworkConfig().getJoin()
                .setMulticastConfig(new MulticastConfig().setEnabled(false))
                .setTcpIpConfig(new TcpIpConfig().setEnabled(true).addMember("127.0.0.1:5523"));
       config.getSerializationConfig().addDataSerializableFactory
               (1, (int id) -> (id == 1) ? new Product() : null);
        return config;
    }


}


