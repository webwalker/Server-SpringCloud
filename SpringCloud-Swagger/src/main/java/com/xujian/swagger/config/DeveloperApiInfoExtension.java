package com.xujian.swagger.config;

import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;
import java.util.List;

public class DeveloperApiInfoExtension implements VendorExtension<List<DeveloperApiInfo>> {

    private final String EXTEND_API_INFO = "x-developers";

    private List<DeveloperApiInfo> developerApiInfoExtensions = new ArrayList<>();

    public DeveloperApiInfoExtension addDeveloper(DeveloperApiInfo developerApiInfo) {
        developerApiInfoExtensions.add(developerApiInfo);
        return this;
    }

    @Override
    public String getName() {
        return EXTEND_API_INFO;
    }

    @Override
    public List<DeveloperApiInfo> getValue() {
        return developerApiInfoExtensions;
    }
}
