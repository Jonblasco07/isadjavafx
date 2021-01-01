package ehu.isad.model;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Txanpona {
    int trade_id;
    public float price;
    float size;
    String time;
    float bid;
    float ask;
    float volume;

    @Override
    public String toString() {
        return "Txanpona{" +
                "trade_id=" + trade_id +
                ", prize=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                '}';
    }

}
