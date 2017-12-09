package com.sa45.team3.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sa45.team3.repository.ProductRepository;

@RequestMapping(value="/admin")
@Controller
public class ReorderPageControl {

	@Resource
	ProductRepository prepo;
}
