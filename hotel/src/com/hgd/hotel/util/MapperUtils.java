package com.hgd.hotel.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperUtils {
	
	private static MapperUtils mapperUtils;
	
	private SqlSessionFactory sessionFactory;
	
	private MapperUtils(){
		SqlSessionFactoryBuilder sessionFactoryBuilder=new SqlSessionFactoryBuilder();
		try {
			sessionFactory=sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MapperUtils getInstence(){
        if(mapperUtils==null)
            mapperUtils = new MapperUtils();
        return mapperUtils;
    }
	
	public <T> T getDao(Class<T> tClass){
        return sessionFactory.openSession(true).getMapper(tClass);
    }
	
}
