package com.nickzim.domain.responce;

import lombok.Data;

@Data
public class Error {

    private Integer error_code;

    private String error_msg;
}
