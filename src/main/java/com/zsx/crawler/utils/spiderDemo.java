package com.zsx.crawler.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.zsx.crawler.pojo.Sanzima;
import com.zsx.crawler.utils.ExcelTools.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class spiderDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("起始页:");
        int start=sc.nextInt();
        System.out.println("结束页:");
        int end=sc.nextInt();
        //引用IO流
        BufferedWriter bw=new BufferedWriter(new FileWriter("jdphone.txt"));
        //目标URL
        URL urlmode=new URL("http://www.haiyun56.cn/dmair/cx.asp?");
        String[] title = {"所属城市", "港口代码", "三字代码", "国家", "国家代码", "四字代码", "名称", "英文","查询价格"};
        String fileName = "世界各国三字代码";
        String sheetName = "世界各国三字代码";
        String[][] content = new String[3359][10];
        int num = 0 ;

        for(int i=start; i<=end; i++) {
            //根据京东翻页建立每一页的URL
            URL url=new URL(urlmode.toString()+"page="+i);
            System.out.println("开始抓取第"+i+"页商品数据");

            //伪装成浏览器并建立连接
            Connection connect=Jsoup.connect(url.toString()).userAgent("Mozilla/5.0");

            //获取网页Document
            Document doc=connect.get();
            //System.out.println(doc.text());

            //解析网页
            Elements elements=doc.getElementsByClass("tdbg");

            //选择器获取文本并以字符串形式存入List
            Elements link=elements.select("td");
            bw.write("=======第"+i+"页商品数据如下:"+"======="+'\n');
            System.out.println(url);

            //打印商品数据
            int count=0;
            for(int j=2; j<link.size()-1; j++) {
                count++;
                String str=link.get(j).text();
                if(str.contains("三字代码搜索")){
                    break ;
                }
                content[num][count-1] = str;
                if(count%9 == 0){
                    str+="\n";
                    count=0;
                    num++;
                }else{
                    str+=",";
                }
                bw.write(str);
                System.out.print(str);
            }
            Thread.sleep(1000);
            System.err.println("第"+i+"页共"+link.size()+"件商品全部写入文件中");
        }

        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName+".xls");
            wb.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //关闭
        bw.close();
        sc.close();
    }
}
