package com.zsx.crawler.pojo;

public class Sanzima {

    /**
     *      <td width="80"><strong>所属城市</strong></td>
     *          <td width="60"><strong>港口代码</strong></td>
     *          <td width="60"><strong>三字代码</strong></td>
     *          <td width="100"><strong>国家</strong></td>
     *          <td width="60"><strong>国家代码</strong></td>
     *          <td width="60"><strong>四字代码</strong></td>
     *          <td width="150"><strong>名称</strong></td>
     *          <td width="150"><strong>英文</strong></td>
     *          <td width="150"><strong>查询价格</strong></td>
     */
    private String city;
    private String code;//公司名称
    private String threeCode;//法人
    private String country;//注册资本
    private String countryCode;//注册时间
    private String fourCode;//电话
    private String name;//邮箱
    private String english;//注册地址
    private String price;//其他

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(String threeCode) {
        this.threeCode = threeCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFourCode() {
        return fourCode;
    }

    public void setFourCode(String fourCode) {
        this.fourCode = fourCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sanzima{" +
                "city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", threeCode='" + threeCode + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fourCode='" + fourCode + '\'' +
                ", name='" + name + '\'' +
                ", english='" + english + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
