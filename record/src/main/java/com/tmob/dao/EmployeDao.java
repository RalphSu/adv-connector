/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tmob.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.tmob.domain.Employee;

/**
 * @since Mar 18, 2018
 *
 */
@Component
public class EmployeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Employee ee) {
        mongoTemplate.save(ee);
    }

    public Employee findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Employee user = mongoTemplate.findOne(query, Employee.class);
        return user;
    }

    public Employee findById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        Employee user = mongoTemplate.findOne(query, Employee.class);
        return user;
    }

    public void updateUser(Employee user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName()).set("password", user.getPassword());
        mongoTemplate.updateFirst(query, update, Employee.class);
        // 更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Employee.class);
    }

}
