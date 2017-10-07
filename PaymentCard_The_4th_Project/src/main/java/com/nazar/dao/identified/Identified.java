package com.nazar.dao.identified;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {
    PK getId();
    void setId(Long id);
}
