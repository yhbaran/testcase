package com.ets.testcase.entity;

import lombok.Data;

@Data
public class FileResponse {
    private Long id;
    private String name;
    private Long size;
    private String url;
    private String contentType;
}
