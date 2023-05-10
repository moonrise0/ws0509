package com.kbstar.service;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.MarkerDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerDescService implements KBService<Integer, MarkerDesc> {
    @Autowired
    MarkerDescMapper mapper;


    @Override
    public void register(MarkerDesc marker) throws Exception {
        mapper.insert(marker);
    }

    @Override
    public void remove(Integer id) throws Exception {
        mapper.delete(id);
    }

    @Override
    public void modify(MarkerDesc marker) throws Exception {
        mapper.update(marker);

    }

    @Override
    public MarkerDesc get(Integer id) throws Exception {
        return mapper.select(id);
    }

    @Override
    public List<MarkerDesc> get() throws Exception {
        return mapper.selectall();
    }

    public List<MarkerDesc> getMarkerDesc(int id) throws Exception{
        return mapper.getmarkerdesc(id);
    }

}
