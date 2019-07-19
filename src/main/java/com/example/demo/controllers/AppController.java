package com.example.demo.controllers;

import com.example.demo.logic.Point;
import com.example.demo.logic.TaskResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @RequestMapping("/rest/count")
    public String printHello(@RequestParam(value = "width",required = false,defaultValue = "8")int w,
                             @RequestParam(value = "height",required = false,defaultValue = "8")int h,
                             @RequestParam(value = "start")String start,
                             @RequestParam(value = "end")String end) {
        String s="";
        int ax,ay,bx,by;
        //Перевод координат доски в численные индексы
        char c=start.charAt(0);
        ax=c-64;
        int i=1;
        ay=0;
        c=start.charAt(i);
        while(i<start.length()){
            ay*=10;
            ay+=(c-48);
            i++;
            if(!(i<start.length()))break;
            c=start.charAt(i);
        }
        Point a=new Point(ax,ay);
        c=end.charAt(0);
        bx=c-64;
        i=1;
        by=0;
        c=end.charAt(i);
        while(i<end.length()){
            by*=10;
            by+=(c-48);
            i++;
            if(!(i<end.length()))break;
            c=end.charAt(i);
        }
        Point b=new Point(bx,by);
        TaskResolver resolver=new TaskResolver();
        int answ= resolver.task(h,w,a,b);

        return Integer.toString(answ);
    }
}
