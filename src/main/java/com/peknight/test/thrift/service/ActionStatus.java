/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.peknight.test.thrift.service;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum ActionStatus implements org.apache.thrift.TEnum {
  Success(0),
  Fail(1);

  private final int value;

  private ActionStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ActionStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return Success;
      case 1:
        return Fail;
      default:
        return null;
    }
  }
}
