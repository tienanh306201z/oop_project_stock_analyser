package readdata;

import java.net.*;

import java.io.*;

import java.time.LocalDate;

import getinformation.*;

public class GetStockInfo {
    private static float  /*vnIndex, pVnIndex,*/ closeIndex, ceil, floor, changeIndex;
    public static float  /*vnIndex, pVnIndex,*/ totalMatchVal;
    public static float  /*vnIndex, pVnIndex,*/ totalPutVal;
    private static float  /*vnIndex, pVnIndex,*/ referencePrice;
    private static float  /*vnIndex, pVnIndex,*/ closePrice;
    private static float  /*vnIndex, pVnIndex,*/ auctionValue;
    private static float  /*vnIndex, pVnIndex,*/ dealValue = 0;
    public static int totalMatchVol, totalPutVol, auctionVolume, dealVolume = 0;
    private static String code;

    public static void GetInfo(LocalDate time) throws Exception {
        BufferedReader br = null, br1 = null, br0 = null, br2 = null;
        try {

            // tạo ngày
            String day = String.valueOf(time.getDayOfMonth());
            String month = String.valueOf(time.getMonthValue());
            String year = String.valueOf(time.getYear());
            if (Integer.parseInt(day) < 10) day = "0" + day;
            if (Integer.parseInt(month) < 10) month = "0" + month;

            //truy cập vào link
            String vnIndexLink2 = "https://finance.vietstock.vn/data/KQGDThongKeGiaPaging?page=1&pageSize=20&catID=1&date=" + year + "-" + month + "-" + day;
            URL url2 = new URL(vnIndexLink2);
            br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            String[] line2 = br2.readLine().split("]", 2);
            int first;

            // line[0] bao gồm các dữ liệu về chỉ số VNIndex trong ngày
            first = line2[0].indexOf("CloseIndex");
            closeIndex = Float.parseFloat(line2[0].substring(first + 12, line2[0].indexOf(",", first)));

            first = line2[0].indexOf("Change");
            changeIndex = Float.parseFloat(line2[0].substring(first + 8, line2[0].indexOf(",", first)));

            // tạo đối tượng VNIndex
            VNIndex dailyVNIndex = new VNIndex(closeIndex, changeIndex);

            // line[1] bao gồm dữ liệu chung của thị trường
            first = line2[1].indexOf("TotalMatchVolStock");
            totalMatchVol = Integer.parseInt(line2[1].substring(first + 20, line2[1].indexOf(",", first)));

            first = line2[1].indexOf("TotalMatchValStock");
            totalMatchVal = Float.parseFloat(line2[1].substring(first + 20, line2[1].indexOf(",", first))) * 1000000;

            first = line2[1].indexOf("TotalPutVolStock");
            totalPutVol = Integer.parseInt(line2[1].substring(first + 18, line2[1].indexOf(",", first)));

            first = line2[1].indexOf("TotalPutValStock");
            totalPutVal = Float.parseFloat(line2[1].substring(first + 18, line2[1].indexOf(",", first))) * 1000000;


            // thêm tất cả các thông tin vừa tìm được vào HashMap
            //StockData.marketHashMap.put(time, new MarketSum(totalMatchVol, totalMatchVal, totalPutVol, totalPutVal));

            //truy cập vào link để lấy thông tin về top cổ phiếu ảnh hưởng đến chỉ số VNIndex trong ngày
            String vnIndexLink1 = "https://finance.vietstock.vn/data/TopStockInfluence?fromDate=" + year + "-" + month + "-" + day + "&toDate=" + year + "-" + month + "-" + day + "&catID=1&top=10&type=0";
            URL url0 = new URL(vnIndexLink1);
            br0 = new BufferedReader(new InputStreamReader(url0.openStream()));
            String[] indexLine1 = br0.readLine().split("\\{");
            for (int i = 1; i <= 20; i++) {
                String stockCode = indexLine1[i].substring(indexLine1[i].indexOf("StockCode") + 12, indexLine1[i].indexOf(",") - 1);
                float influencePoint = Float.parseFloat(indexLine1[i].substring(indexLine1[i].indexOf("InfluenceIndex") + 16, indexLine1[i].indexOf(",\"O")));

                // cập nhật chi tiết cổ phiếu ảnh hưởng cho đối tượng VNIndex
                dailyVNIndex.getVnIndexInfluence().add(new VNIndexInfluence(stockCode, influencePoint));
            }

            // đưa dữ liệu vào HashMap
            StockData.vnIndexHashMap.put(time, dailyVNIndex);


            //truy cập vào link để lấy thông tin về giá cổ phiếu trong ngày
            String link = "https://www.hsx.vn/Modules/Rsde/Report/QuoteReport?pageFieldName1=Date&pageFieldValue1=" + day + "." + month + "." + year + "&pageFieldOperator1=eq&pageFieldName2=KeyWord&pageFieldValue2=&pageFieldOperator2=&pageFieldName3=IndexType&pageFieldValue3=0&pageFieldOperator3=&pageCriteriaLength=3&_search=false&nd=1608441175517&rows=2147483647&page=1&sidx=id&sord=desc";
            URL url1 = new URL(link);
            br1 = new BufferedReader(new InputStreamReader(url1.openStream()));
            String[] line = br1.readLine().split("\\{");
            for (int i = 2; i <= line.length - 1; i++) {
                String fixnull = line[i].replace("null", "\"null\"");
                String[] subline = fixnull.split("\",");
                code = subline[0].substring(subline[0].indexOf(":") + 2, subline[0].length());
                ceil = Float.parseFloat(subline[5].substring(1, subline[5].length()).replace(",", ".")) * 1000;
                floor = Float.parseFloat(subline[6].substring(1, subline[6].length()).replace(",", ".")) * 1000;
                referencePrice = Float.parseFloat(subline[7].substring(1, subline[7].length()).replace(",", ".")) * 1000;
                closePrice = Float.parseFloat(subline[9].substring(1, subline[9].length()).replace(",", ".")) * 1000;
                auctionVolume = Integer.parseInt(subline[15].substring(1, subline[15].length() - 1).replace(",", "").replace(".", ""));
                auctionValue = Float.parseFloat(subline[16].substring(1, subline[16].indexOf("]") - 1).replace(",", ".").replace(".", "")) * 1000000;

                // thêm tất cả các thông tin vừa tìm được vào các HashMap
                StockCode stockCode = new StockCode(code, new Price(referencePrice, closePrice, ceil, floor),
                        new Transaction(auctionVolume, auctionValue, dealVolume, dealValue));
                StockData.stockCodeHashMap.put(code,stockCode);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }
	/*
	public static void main(String[] args) throws Exception {
		try {
			LocalDate k = LocalDate.of(2020, 12, 9);
			GetInfo(k);
			System.out.println(StockData.vnIndexHashMap.get(k).getCloseIndex());
		}
		catch (IOException e) {
            e.printStackTrace();
		}
	}*/
}