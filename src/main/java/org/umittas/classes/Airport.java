package org.umittas.classes;

public class Airport {
    private String name;
    private String iatacode;
    private String city;
    private String province;
    private String country;

    public Airport(){
    }

    public Airport(String name,String iatacode, String city,String province,String country){
        this.name = name;
        this.iatacode = iatacode;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public String getName(){
        return name;
    }

    public String getIatacode(){
        return iatacode;
    }

    public String getCity(){
        return city;
    }

    public String getProvince(){
        return province;
    }

    public String getCountry(){
        return country;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setIatacode(String _iatacode){
        this.iatacode=_iatacode;
    }

    public void setCity(String _city){
        this.city = _city;
    }

    public void setProvince(String _province){
        this.province=_province;
    }

    public void setCountry(String _country){
        this.country=_country;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Airport: " + this.name + " ");
        str.append("IATA Code:" + this.iatacode + " ");
        str.append("City: " + this.city + " ");
        str.append("Province: " + this.province + " ");
        str.append("Country: " + this.country + " ");

        return str.toString();
    }
}
