package com.mycompany.factorybuilder;

public enum BodyType {

  SKINNY,
  FIT,
  MUSCULAR,
  FAT;



  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
