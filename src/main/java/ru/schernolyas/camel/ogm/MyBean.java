/*
 * #%L
 * Wildfly Camel
 * %%
 * Copyright (C) 2013 - 2015 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package ru.schernolyas.camel.ogm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;


public class MyBean {
   private static Logger logger = Logger.getLogger(MyBean.class);
   private EntityManager entityManager;

   public void init() {
      logger.info("call init method");
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NEO4JBOLT_OGM_PU");
      entityManager = entityManagerFactory.createEntityManager();
   }


   public String createNewPerson(String name) {
      logger.info("call createNewPerson method");

      EntityTransaction et = entityManager.getTransaction();
      Person person = null;
      try {
         et.begin();
         person = new Person();
         person.setName(name);
         entityManager.persist(person);
         et.commit();
      } finally {
         et.rollback();

      }
      return person != null ? "New person with Id " + person.getId() : "No new person!";
   }
}
