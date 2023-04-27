
package com.mycompany.factorybuilder;


public enum CharacterTypes {
  ARCHER,FLAG_BEARER,KNIGHT;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
