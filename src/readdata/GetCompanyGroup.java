package readdata;

import java.io.*;

import getinformation.*;

public class GetCompanyGroup {

    public static void GetCompanyInfo(File csv) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while (true) {
                line = br.readLine();
                if (line != null) {
                    String[] subline = line.split(";");
                    String code = subline[0];
                    String companyName = subline[1];
                    String groupName = subline[2];
                    String vn30 = subline[3];

                    if (vn30.equals("1")) {
                        StockData.vn30.add(code);
                    }
                    StockData.group.add(code);
                    StockData.companyNameHashMap.put(code, companyName);
                    if (StockData.groupHashMap.containsKey(groupName)) {
                        StockData.groupHashMap.get(groupName).getList().add(code);
                    }
                    else {
                        StockData.groupHashMap.put(groupName, new CompanyGroup(groupName, code));
                    }
                } else break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }
	/*public static void main(String[] args) {
		String filePath = new File("").getAbsolutePath();
		String path1 = filePath + "\\src\\readdata\\CompanyName.csv";
		GetCompanyInfo(new File(path1));
		System.out.println(StockData.vn30.get(6));
	}*/
}
