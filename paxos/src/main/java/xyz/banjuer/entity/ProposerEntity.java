package xyz.banjuer.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ProposerEntity implements Serializable {
    public boolean chosen_flag;
    public boolean help_chosen_flag;
    public String chosen_v;
    public int next_e;

}
