package Tests.day22_review;

import Utils.ExcelUtil;
import org.testng.annotations.Test;

public class ReadTestDataFromExcelFile {
    //burada excel dosyasini surukleyerek Summer2019OnlineTestNGSeleniumProject a birakiyoruz

    @Test
    public  void test1(){
        ExcelUtil cars=new ExcelUtil("cars.xlsx","cars");
        System.out.println(cars.getDataList());
        //get(0) means get data from first row
        //get("Color") means get value of Color column, from first row
        String color=cars.getDataList().get(0).get("Color");
        String driverName=cars.getDataList().get(0).get("Driver");
        System.out.println(color);// burada get(0) diyerek ilk satiri kastettik, sonrasinda "Color" olan yeri kasttk
        System.out.println(cars.getDataList().get(0));




    }
}
