package com.up.service.impl;

import com.up.mapper.MixMapper;
import com.up.service.MixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PACKAGE com.up.service.impl.MixServiceImpl
 * @DATE 2019/10/7 8:39
 * @AUTHOR LZ
 * @EFFECT
 **/
@Service
public class MixServiceImpl implements MixService {
    @Autowired
    private MixMapper mixMapper;

    @Override
    public void study(String substring) {
        this.mixMapper.study(substring);
    }
}
