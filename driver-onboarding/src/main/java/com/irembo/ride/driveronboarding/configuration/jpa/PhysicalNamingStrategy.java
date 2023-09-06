package com.irembo.ride.driveronboarding.configuration.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.model.AnnotationBasedPersistentProperty;
import org.springframework.data.relational.core.mapping.BasicRelationalPersistentProperty;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
import org.springframework.util.Assert;

public class PhysicalNamingStrategy implements NamingStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getTableName(Class<?> type) {

        Assert.notNull(type, "Type must not be null");

        if(type.isAnnotationPresent(Table.class)
        && type.getAnnotation(Table.class).name()!=null
        ){
            return type.getAnnotation(Table.class).name();
        }

        return NamingStrategy.super.getTableName(type);
    }

    @Override
    public String getColumnName(RelationalPersistentProperty property) {

        Assert.notNull(property, "property cannot be null");

        logger.trace("getting column name for {}", property.getName());
        if (property instanceof BasicRelationalPersistentProperty) {
            logger.trace("property is BasicRelationalPersistentProperty");

            BasicRelationalPersistentProperty aProperty = (BasicRelationalPersistentProperty) property;
            logger.debug("name {}", aProperty.getName());
            logger.trace("is entity {}", aProperty.isEntity());
            logger.trace("is association {}", aProperty.isAssociation());
            logger.trace("getKeyColumn {}", aProperty.getKeyColumn());
            logger.trace("is annotation present (ManyToOne) {}", aProperty.isAnnotationPresent(ManyToOne.class));

            if (aProperty.isAnnotationPresent(ManyToOne.class)
                    && aProperty.isAnnotationPresent(JoinColumn.class)
            ) {
                logger.debug("property has ManyToOne and JoinColumn annotations");
                logger.debug("returning {}", aProperty.findAnnotation(JoinColumn.class).name());
                return aProperty.findAnnotation(JoinColumn.class).name();
            } else if (aProperty.isAnnotationPresent(ManyToOne.class)) {
                logger.trace("property has ManyToOne annotation");
                logger.trace("returning {}", aProperty.getName().concat("_id"));
                return aProperty.getName().concat("_id");
            } else if (aProperty.isAnnotationPresent(Column.class)
                    && !aProperty.findAnnotation(Column.class).name().isEmpty()) {
                logger.trace("property has Column annotation");

                logger.trace("returning {}", aProperty.findAnnotation(Column.class).name());
                return aProperty.findAnnotation(Column.class).name();
            }

            return aProperty.getName();
        } else if (property instanceof AnnotationBasedPersistentProperty) {
            logger.trace("property is AnnotationBasedPersistentProperty");

            return ((AnnotationBasedPersistentProperty) property).getName();
        } else {
            logger.trace("property is {}", property.getClass().getName());
        }

        return property.getName();
    }


}