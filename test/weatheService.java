import client.WeatherWebServiceLocator;
import client.WeatherWebServiceSoap_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class weatheService {
    public static void main(String[] args) {
        try {
            // 1.创建Locator对象,相当于传统服务的类或者是库
            WeatherWebServiceLocator weatherWebServiceLocator = new WeatherWebServiceLocator();
            // 2.获取port,相当于传统类或库的方法接口
            WeatherWebServiceSoap_PortType wwsp = weatherWebServiceLocator.getWeatherWebServiceSoap();
            // 3.通过port调用服务
            String[] weather = wwsp.getWeatherbyCityName("长沙");
            // 4.打印获得的结果
            for (String info : weather) {
                System.out.println(info);
            }
        }catch (ServiceException | RemoteException ex){
            ex.printStackTrace();
        }
    }
}
