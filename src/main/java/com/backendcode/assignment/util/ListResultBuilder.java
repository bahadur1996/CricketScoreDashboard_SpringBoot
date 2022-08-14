package com.backendcode.assignment.util;

import com.backendcode.assignment.mapper.EntityModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListResultBuilder {

	public static <I, O> List<O>  build(List<I> list, EntityModelMapper<I, O> mapperFunction) {
		
		return list.stream().map(entity-> mapperFunction.map(entity)).collect(Collectors.toList());
		
	}
	
}