package com.iticbcn.melie.models;

import java.io.Serializable;
import java.sql.Date;

public class Historic implements Serializable {
    private int id;
    private Date data_inici;
    private Date data_fi;
    private String comentaris;
}
