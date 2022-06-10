package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.config.MaxSizePolicy;


public class EmpCacheConfig {
	
	@Bean
	//method name can be anything but it shld return Config Object..
	public Config cacheConfig()
	{
		return new Config()
			.setInstanceName("hazel-instance")
			.addMapConfig(new MapConfig()
					.setName("Emp-cache")
					.setTimeToLiveSeconds(3000)
					//.setMapStoreConfig(new MapStoreConfig())
					.setMaxSizeConfig(new MazSizeConfig(200,MaxSizePolicy.FREE_HEAP_SIZE))
					.setEvictionPolicy(EvictionPolicy.LRU)
					
	          
	}

}
