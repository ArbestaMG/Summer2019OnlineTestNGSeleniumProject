package Utils;
// bunu yaptik  , boylece configuration.properties dosyasindaki datalari aldik

import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    //this class will be responsible for loading properties file and will provide access
    //to values based on key names
    //we use Properties class to load custom .properties files
    private static Properties configFile;
    static {
        try {
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be executed
            //any class that is related to InputOutput produce checked exceptions
            //without handling checked exception, you cannot run a code
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //initialize properties object
            configFile = new Properties();
            //load configuration.properties file
            configFile.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}
