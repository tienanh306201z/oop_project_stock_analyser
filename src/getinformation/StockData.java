
//Lớp khởi tạo Hashmap để lưu trữ dữ liệu

package getinformation;

import java.util.HashMap;

import java.util.ArrayList;

import java.time.LocalDate;

public class StockData {
    public static ArrayList<String> vn30 = new ArrayList<String>();
    public static HashMap<LocalDate, MarketSum> marketHashMap = new HashMap<LocalDate, MarketSum>();
    public static HashMap<String, StockCode> stockCodeHashMap = new HashMap<String, StockCode>();
    public static ArrayList<String> group = new ArrayList<String>();
    public static HashMap<String, ForeignTransaction> foreignHashMap = new HashMap<String, ForeignTransaction>();
    public static HashMap<String, CompanyGroup> groupHashMap = new HashMap<String, CompanyGroup>();
    public static HashMap<String, String> companyNameHashMap = new HashMap<String, String>();
    public static HashMap<LocalDate, VNIndex> vnIndexHashMap = new HashMap<LocalDate, VNIndex>();
}
