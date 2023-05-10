package com.kbstar.controller;

import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ChartImplController {
    @Autowired
    SalesService salesService;
    @RequestMapping("/chart1")
    public Object chart1() throws Exception {
        List<Integer> mprice = null;
        mprice = salesService.mprice();
        List<Integer> wprice = null;
       wprice = salesService.wprice();

        JSONArray ja = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("mprice", mprice);
        jo.put("wprice", wprice);
        return jo;
    }
    @RequestMapping("/chart2")
    public Object chart2() throws Exception{
        List<Integer> wprice = null;
        wprice = salesService.wprice();
        JSONArray ja2 = new JSONArray();
        for (int i = 0; i < wprice.size(); i++) {
            JSONArray ja = new JSONArray();
            ja.add( i+1+"월");
            ja.add(wprice.get(i));
            ja2.add(ja);
        }
        return ja2;
    }
    @RequestMapping("/chart3")
    public Object chart3() throws Exception{
        List<Integer> mprice = null;
        mprice = salesService.mprice();
        JSONArray ja2 = new JSONArray();
        for (int i = 0; i < mprice.size(); i++) {
            JSONArray ja = new JSONArray();
            ja.add( i+1+"월");
            ja.add(mprice.get(i));
            ja2.add(ja);
        }
        return ja2;
    }
}