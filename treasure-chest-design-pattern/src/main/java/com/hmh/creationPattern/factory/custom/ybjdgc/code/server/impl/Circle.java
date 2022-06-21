package com.hmh.creationPattern.factory.custom.ybjdgc.code.server.impl;

import com.hmh.creationPattern.factory.custom.ybjdgc.code.server.Shape;
import org.springframework.stereotype.Service;

@Service
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}

