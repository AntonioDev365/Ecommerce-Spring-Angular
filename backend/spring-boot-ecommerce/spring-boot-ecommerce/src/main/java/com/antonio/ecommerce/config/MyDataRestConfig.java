package com.antonio.ecommerce.config;

import com.antonio.ecommerce.entity.Country;
import com.antonio.ecommerce.entity.Product;
import com.antonio.ecommerce.entity.ProductCategory;
import javax.persistence.metamodel.EntityType;

import com.antonio.ecommerce.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//To make read-only
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    //Autowire JPA entity manager to expose entities id
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsuportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable HTTP methods for Product: PUT, POST and DELETE
        disableHttpMethods(Product.class,config, theUnsuportedActions);
        disableHttpMethods(ProductCategory.class,config, theUnsuportedActions);
        disableHttpMethods(Country.class,config, theUnsuportedActions);
        disableHttpMethods(Province.class,config, theUnsuportedActions);

        // call an internal method to exposeIds
        exposeIds(config);
    }

    //Method to refactor and avoid code repetition, passing the class as a parameter
    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsuportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsuportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsuportedActions)));
    }

    //expose entity ids
    private void exposeIds(RepositoryRestConfiguration config){

        //get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities=entityManager.getMetamodel().getEntities();

        //create an array of the entity types
        List<Class> entityClasses=new ArrayList<>();

        //get the entity types for the entities
        for(EntityType tempEntityType: entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes=entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes); //this method will accept an array of entity/domain types and it will configure
        //Spring Data REST to include the "id" field in JSON responses
    }

}
