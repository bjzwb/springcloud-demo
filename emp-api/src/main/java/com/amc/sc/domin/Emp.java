package com.amc.sc.domin;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Emp {

    private static final long serialVersionUID = -8415978407764459720L;

    private Long tid;

    private String empName;

    private String dbSource;

}
