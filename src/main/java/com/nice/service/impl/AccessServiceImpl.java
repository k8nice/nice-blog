package com.nice.service.impl;

import com.nice.mapper.AccessMapper;
import com.nice.model.Access;
import com.nice.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nice
 */
@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessMapper accessMapper;

    @Override
    public void addAccess(Access access) {
        accessMapper.addAccess(access);
    }

    @Override
    public Long dayAccess(Access access) {
        return accessMapper.dayAccess(access);
    }

    @Override
    public Long weekAccess(Access access) {
        return accessMapper.weekAccess(access);
    }

    @Override
    public Long monthAccess(Access access) {
        return accessMapper.monthAccess(access);
    }

    @Override
    public Long yearAccess(Access access) {
        return accessMapper.yearAccess(access);
    }
}
