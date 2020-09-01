package pers.lishbo.util.redis;

import org.junit.Test;

import pers.lishbo.aservice.abstractservice.GanSuService;
import pers.lishbo.aservice.commonservice.CutDataSourceService;
import pers.lishbo.aservice.commonservice.impl.CutDataSourceServiceImpl;

public class redisTest {
    @Test  
    public void getSettUnitBySettUnitIdTest() {  
        String systemId = "CES";  
        String merchantId = "133";  
        String configSettUnit1 =new CutDataSourceServiceImpl().findSchool("1");  
        String configSettUnit2 =new CutDataSourceServiceImpl().findSchool("1");  
//        GanSuService configSettUnit = GanSuService.testkind();  
//        boolean flag= (configSettUnit == configSettUnit1);  
//        System.out.println(configSettUnit);  
//        logger.info("查找结果" + configSettUnit.getBusinessType());  
//        
//      //  localSecondFIFOCache.put("configSettUnit", configSettUnit.getBusinessType());  
//     //  String string = localSecondFIFOCache.get("configSettUnit");  
//          logger.info("查找结果" + string);  
    }  
}
