package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.dto.Marker;
import com.kbstar.dto.MarkerSearch;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/marker")
public class MarkerController {
    @Autowired
    MarkerService markerService;
    String dir = "marker/";

    @Value("${uploadimgdir}")
    String imgdir;
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, Marker obj) throws Exception {
        MultipartFile mf = obj.getMimg();
        String imgname = mf.getOriginalFilename();
        obj.setImg(imgname);
        markerService.register(obj);
        FileUploadUtil.saveFile(mf,imgdir);
        return "redirect:all";
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model,int id) throws Exception {
        markerService.remove(id);
        return "redirect:all";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Marker obj) throws Exception {
        MultipartFile mf = obj.getMimg();
        String new_imgname = mf.getOriginalFilename();
        if(new_imgname.equals("") || new_imgname == null){
            markerService.modify(obj);
        }else{
            obj.setImg(new_imgname);
            markerService.modify(obj);
            FileUploadUtil.saveFile(mf,imgdir);
        }

        return "redirect:detail?id="+obj.getId();
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Marker> list = null;
        list = markerService.get();
        model.addAttribute("mlist",list);
        model.addAttribute("center",dir+"all");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, int id) throws Exception {
        Marker obj = null;
        obj = markerService.get(id);
        model.addAttribute("gmarker",obj);
        model.addAttribute("center",dir+"detail");
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model, MarkerSearch ms) throws Exception {
//        if(ms.getLoc().isEmpty()) {
//               ms.setLoc(null);
//        }
//        if(ms.getTitle().isEmpty()) {
//
//            ms.setTitle(null);
//        }
        List<Marker> list = markerService.search(ms);
        model.addAttribute("ms", ms);
        model.addAttribute("mlist",list);
        model.addAttribute("center", dir+"all");
        return "index";




//       if(ms.getLoc() == null){
//           log.info("--------------------null");
//        }else{
//           log.info("--------------------empty");
//       }


    }


}