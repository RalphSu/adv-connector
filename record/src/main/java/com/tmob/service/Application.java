/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tmob.service;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

/**
 * @since Feb 20, 2018
 *
 */

@SpringBootApplication
@ComponentScan("com.tmob")
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket newsApi() {
        String env = System.getProperty("spring.profiles.active");
        if ("local".equals(env)) {
            env = null;
        }

        return new Docket(DocumentationType.SWAGGER_2).pathMapping(env)
                .select().apis(RequestHandlerSelectors.any()).paths(paths())
                .build().apiInfo(apiInfo());
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }

    private Predicate<String> paths() {
        return or(regex("/folderManagement.*"), regex("/integration.*"),
                regex("/hadoop.*"), regex("/request.*"), regex("/queue.*"),
                regex("/user.*"), regex("/batch.*"), regex("/webhdfs.*"),
                regex("/quota.*"), regex("/info.*"), regex("/jobList.*"),
                regex("/frontendTest.*"), regex("/job.*"), regex("/group.*"),
                regex("/storage.*"), regex("/setup.*"), regex("/app.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Rest API for HMC")
                .contact("DL-eBay-Hadoop-HMC-Devs").version("1.0.0").build();
    }
}
