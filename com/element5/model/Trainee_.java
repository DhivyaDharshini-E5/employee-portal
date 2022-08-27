package com.element5.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trainee.class)
public abstract class Trainee_ extends com.element5.model.Employee_ {

	public static volatile SingularAttribute<Trainee, String> collegeName;
	public static volatile SingularAttribute<Trainee, String> taskName;
	public static volatile SingularAttribute<Trainee, String> passOutYear;

	public static final String COLLEGE_NAME = "collegeName";
	public static final String TASK_NAME = "taskName";
	public static final String PASS_OUT_YEAR = "passOutYear";

}

