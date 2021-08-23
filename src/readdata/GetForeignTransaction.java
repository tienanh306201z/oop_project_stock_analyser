package readdata;

import java.io.*;

import getinformation.*;

public class GetForeignTransaction {
    public static void GetForeign(File csv) {
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
                    float fBuyVolume = Float.parseFloat(subline[1]);
                    float fBuyValue = Float.parseFloat(subline[2]);
                    float fSellVolume = Float.parseFloat(subline[3]);
                    float fSellValue = Float.parseFloat(subline[4]);

                    StockData.foreignHashMap.put(code, new ForeignTransaction(code, fSellValue, fBuyValue, fBuyVolume, fSellVolume));
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
}
