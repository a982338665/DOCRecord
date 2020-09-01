package test.erweima;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取properties文件
 * @author cjh
 *
 */
public class TestProperties {

    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new ClassNotFoundException(fileName + " file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                }catch (IOException e){
//                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }
    public static void main(String[] args) {
    	Properties props=loadProps("com/sql.properties");
    	System.out.println(props.getProperty("mess"));
	}
}
