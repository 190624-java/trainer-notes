package com.revature.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

//@Scope("singleton")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DAO {

}
