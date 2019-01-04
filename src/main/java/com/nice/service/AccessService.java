package com.nice.service;

import com.nice.model.Access;

public interface AccessService {
    void addAccess(Access access);
    Long dayAccess(Access access);
    Long weekAccess(Access access);
    Long monthAccess(Access access);
    Long yearAccess(Access access);
}
