package com.seohyuni.returneverytimeserver.config.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
    @ApiImplicitParam(name = "page", dataType = "string", paramType = "query", value = "페이지 인덱스"),
    @ApiImplicitParam(name = "size", dataType = "string", paramType = "query", value = "페이지당 개수"),
    @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query", allowMultiple = true, value = "페이지 정렬")
})
public @interface ApiPageable {

}
