package xyz.banjuer.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class AcceptorEntity implements Serializable {
    public boolean op_flag;
    public String id;
    public String cfg;
    public int p_e;
    public int a_e;
    public String a_v;

}
