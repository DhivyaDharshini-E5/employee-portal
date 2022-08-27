package com.element5.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trainer.class)
public abstract class Trainer_ extends com.element5.model.Employee_ {

	public static volatile SingularAttribute<Trainer, String> dateOfJoining;
	public static volatile SingularAttribute<Trainer, String> projectName;
	public static volatile SingularAttribute<Trainer, Integer> experience;

	public static final String DATE_OF_JOINING = "dateOfJoining";
	public static final String PROJECT_NAME = "projectName";
	public static final String EXPERIENCE = "experience";

}

