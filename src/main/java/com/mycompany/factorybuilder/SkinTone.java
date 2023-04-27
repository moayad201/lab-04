package com.mycompany.factorybuilder;


public enum SkinTone {

  FAIR, LIGHT, MEDIUM , DARK;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
