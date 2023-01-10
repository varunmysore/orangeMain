package dataproviders;

import org.testng.annotations.DataProvider;

import generic.ActionUtils;
import generic.BaseClass;

public class StoreData {
@DataProvider
public Object[][] objData() {
	Object[][] d=new Object[1][6];
	d[0][0]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 0);
	d[0][1]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 1);
	d[0][2]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 2);
	d[0][3]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 3);
	d[0][4]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 4);
	d[0][5]=ActionUtils.getdata(BaseClass.excelpath, "orange", 1, 5);
	return d;
}
}
