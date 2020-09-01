package pers.lishbo.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * --1.public abstract class AbstractRoutingDataSource extends AbstractDataSource
 * 		implements InitializingBean
 *		(AbstractDataSource是javax.sql.DataSource的子类)
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	@Override 
	protected Object determineCurrentLookupKey() {  
		return DataSourceContextHolder.getDataSourceType();  
	}  
    /*public void setTargetDataSources(Map<Object, Object> targetDataSources) { 
	    super.setTargetDataSources(targetDataSources); 
	    afterPropertiesSet(); 
	} */
}
