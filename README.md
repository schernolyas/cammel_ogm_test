# Apache Camel with Hibernamte OGM test
Test for combination of Wildfly + Apache Camel + Hibernate OGM

I checked next versions:
1) wildfly-camel-patch-5.1.0.tar.gz
2) Hibernate OGM 5.3.1.Final

I used EntityManager directly because using JPA by Spring (4.3.12.RELEASE) lead to blocker problem (exception)
