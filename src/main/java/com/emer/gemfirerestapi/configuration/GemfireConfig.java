package com.emer.gemfirerestapi.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.emer.gemfirerestapi.model.Customer;
import com.gemstone.gemfire.cache.GemFireCache;

/**
 * 
 * @author Emerson Javid Gonzalez Morales
 *
 *Config Gemfire storage
 *Config CacheFactoryBean and LocalRegionFactoryBean
 *
 *@Configuration tags the class as a source of bean definitions for the application context.
 *
 *A GemFire cache is required, to store all data. 
 *For that, you have Spring Data GemFire’s convenient CacheFactoryBean.
 */

@Configuration
public class GemfireConfig {
	
	@Bean
	Properties gemfireProperties(){
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}
	
	@Bean
	CacheFactoryBean gemfireCache(){
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}
	
	@Bean
	LocalRegionFactoryBean<String, Customer> customerRegion(final GemFireCache cache){
		LocalRegionFactoryBean<String, Customer> customerRegion = new LocalRegionFactoryBean<>();
		customerRegion.setCache(cache);
		customerRegion.setClose(true);
		customerRegion.setName("customer");
		customerRegion.setPersistent(false);
		return customerRegion;
	}

}
