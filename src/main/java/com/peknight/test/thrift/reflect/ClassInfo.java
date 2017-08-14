/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.peknight.test.thrift.reflect;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-08-11")
public class ClassInfo implements org.apache.thrift.TBase<ClassInfo, ClassInfo._Fields>, java.io.Serializable, Cloneable, Comparable<ClassInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ClassInfo");

  private static final org.apache.thrift.protocol.TField CLASS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("className", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COMPONENT_CLASS_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("componentClassList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField IMPLEMENT_CLASS_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("implementClassList", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField CONSTRUCTOR_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("constructorList", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField ENUM_VALUES_FIELD_DESC = new org.apache.thrift.protocol.TField("enumValues", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ClassInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ClassInfoTupleSchemeFactory();

  public java.lang.String className; // required
  public java.util.List<ClassInfo> componentClassList; // required
  public java.util.List<ClassInfo> implementClassList; // required
  public java.util.List<ConstructorInfo> constructorList; // required
  public java.util.List<java.lang.String> enumValues; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLASS_NAME((short)1, "className"),
    COMPONENT_CLASS_LIST((short)2, "componentClassList"),
    IMPLEMENT_CLASS_LIST((short)3, "implementClassList"),
    CONSTRUCTOR_LIST((short)4, "constructorList"),
    ENUM_VALUES((short)5, "enumValues");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CLASS_NAME
          return CLASS_NAME;
        case 2: // COMPONENT_CLASS_LIST
          return COMPONENT_CLASS_LIST;
        case 3: // IMPLEMENT_CLASS_LIST
          return IMPLEMENT_CLASS_LIST;
        case 4: // CONSTRUCTOR_LIST
          return CONSTRUCTOR_LIST;
        case 5: // ENUM_VALUES
          return ENUM_VALUES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLASS_NAME, new org.apache.thrift.meta_data.FieldMetaData("className", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMPONENT_CLASS_LIST, new org.apache.thrift.meta_data.FieldMetaData("componentClassList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ClassInfo"))));
    tmpMap.put(_Fields.IMPLEMENT_CLASS_LIST, new org.apache.thrift.meta_data.FieldMetaData("implementClassList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ClassInfo"))));
    tmpMap.put(_Fields.CONSTRUCTOR_LIST, new org.apache.thrift.meta_data.FieldMetaData("constructorList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ConstructorInfo"))));
    tmpMap.put(_Fields.ENUM_VALUES, new org.apache.thrift.meta_data.FieldMetaData("enumValues", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ClassInfo.class, metaDataMap);
  }

  public ClassInfo() {
  }

  public ClassInfo(
    java.lang.String className,
    java.util.List<ClassInfo> componentClassList,
    java.util.List<ClassInfo> implementClassList,
    java.util.List<ConstructorInfo> constructorList,
    java.util.List<java.lang.String> enumValues)
  {
    this();
    this.className = className;
    this.componentClassList = componentClassList;
    this.implementClassList = implementClassList;
    this.constructorList = constructorList;
    this.enumValues = enumValues;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ClassInfo(ClassInfo other) {
    if (other.isSetClassName()) {
      this.className = other.className;
    }
    if (other.isSetComponentClassList()) {
      java.util.List<ClassInfo> __this__componentClassList = new java.util.ArrayList<ClassInfo>(other.componentClassList.size());
      for (ClassInfo other_element : other.componentClassList) {
        __this__componentClassList.add(other_element);
      }
      this.componentClassList = __this__componentClassList;
    }
    if (other.isSetImplementClassList()) {
      java.util.List<ClassInfo> __this__implementClassList = new java.util.ArrayList<ClassInfo>(other.implementClassList.size());
      for (ClassInfo other_element : other.implementClassList) {
        __this__implementClassList.add(other_element);
      }
      this.implementClassList = __this__implementClassList;
    }
    if (other.isSetConstructorList()) {
      java.util.List<ConstructorInfo> __this__constructorList = new java.util.ArrayList<ConstructorInfo>(other.constructorList.size());
      for (ConstructorInfo other_element : other.constructorList) {
        __this__constructorList.add(other_element);
      }
      this.constructorList = __this__constructorList;
    }
    if (other.isSetEnumValues()) {
      java.util.List<java.lang.String> __this__enumValues = new java.util.ArrayList<java.lang.String>(other.enumValues);
      this.enumValues = __this__enumValues;
    }
  }

  public ClassInfo deepCopy() {
    return new ClassInfo(this);
  }

  @Override
  public void clear() {
    this.className = null;
    this.componentClassList = null;
    this.implementClassList = null;
    this.constructorList = null;
    this.enumValues = null;
  }

  public java.lang.String getClassName() {
    return this.className;
  }

  public ClassInfo setClassName(java.lang.String className) {
    this.className = className;
    return this;
  }

  public void unsetClassName() {
    this.className = null;
  }

  /** Returns true if field className is set (has been assigned a value) and false otherwise */
  public boolean isSetClassName() {
    return this.className != null;
  }

  public void setClassNameIsSet(boolean value) {
    if (!value) {
      this.className = null;
    }
  }

  public int getComponentClassListSize() {
    return (this.componentClassList == null) ? 0 : this.componentClassList.size();
  }

  public java.util.Iterator<ClassInfo> getComponentClassListIterator() {
    return (this.componentClassList == null) ? null : this.componentClassList.iterator();
  }

  public void addToComponentClassList(ClassInfo elem) {
    if (this.componentClassList == null) {
      this.componentClassList = new java.util.ArrayList<ClassInfo>();
    }
    this.componentClassList.add(elem);
  }

  public java.util.List<ClassInfo> getComponentClassList() {
    return this.componentClassList;
  }

  public ClassInfo setComponentClassList(java.util.List<ClassInfo> componentClassList) {
    this.componentClassList = componentClassList;
    return this;
  }

  public void unsetComponentClassList() {
    this.componentClassList = null;
  }

  /** Returns true if field componentClassList is set (has been assigned a value) and false otherwise */
  public boolean isSetComponentClassList() {
    return this.componentClassList != null;
  }

  public void setComponentClassListIsSet(boolean value) {
    if (!value) {
      this.componentClassList = null;
    }
  }

  public int getImplementClassListSize() {
    return (this.implementClassList == null) ? 0 : this.implementClassList.size();
  }

  public java.util.Iterator<ClassInfo> getImplementClassListIterator() {
    return (this.implementClassList == null) ? null : this.implementClassList.iterator();
  }

  public void addToImplementClassList(ClassInfo elem) {
    if (this.implementClassList == null) {
      this.implementClassList = new java.util.ArrayList<ClassInfo>();
    }
    this.implementClassList.add(elem);
  }

  public java.util.List<ClassInfo> getImplementClassList() {
    return this.implementClassList;
  }

  public ClassInfo setImplementClassList(java.util.List<ClassInfo> implementClassList) {
    this.implementClassList = implementClassList;
    return this;
  }

  public void unsetImplementClassList() {
    this.implementClassList = null;
  }

  /** Returns true if field implementClassList is set (has been assigned a value) and false otherwise */
  public boolean isSetImplementClassList() {
    return this.implementClassList != null;
  }

  public void setImplementClassListIsSet(boolean value) {
    if (!value) {
      this.implementClassList = null;
    }
  }

  public int getConstructorListSize() {
    return (this.constructorList == null) ? 0 : this.constructorList.size();
  }

  public java.util.Iterator<ConstructorInfo> getConstructorListIterator() {
    return (this.constructorList == null) ? null : this.constructorList.iterator();
  }

  public void addToConstructorList(ConstructorInfo elem) {
    if (this.constructorList == null) {
      this.constructorList = new java.util.ArrayList<ConstructorInfo>();
    }
    this.constructorList.add(elem);
  }

  public java.util.List<ConstructorInfo> getConstructorList() {
    return this.constructorList;
  }

  public ClassInfo setConstructorList(java.util.List<ConstructorInfo> constructorList) {
    this.constructorList = constructorList;
    return this;
  }

  public void unsetConstructorList() {
    this.constructorList = null;
  }

  /** Returns true if field constructorList is set (has been assigned a value) and false otherwise */
  public boolean isSetConstructorList() {
    return this.constructorList != null;
  }

  public void setConstructorListIsSet(boolean value) {
    if (!value) {
      this.constructorList = null;
    }
  }

  public int getEnumValuesSize() {
    return (this.enumValues == null) ? 0 : this.enumValues.size();
  }

  public java.util.Iterator<java.lang.String> getEnumValuesIterator() {
    return (this.enumValues == null) ? null : this.enumValues.iterator();
  }

  public void addToEnumValues(java.lang.String elem) {
    if (this.enumValues == null) {
      this.enumValues = new java.util.ArrayList<java.lang.String>();
    }
    this.enumValues.add(elem);
  }

  public java.util.List<java.lang.String> getEnumValues() {
    return this.enumValues;
  }

  public ClassInfo setEnumValues(java.util.List<java.lang.String> enumValues) {
    this.enumValues = enumValues;
    return this;
  }

  public void unsetEnumValues() {
    this.enumValues = null;
  }

  /** Returns true if field enumValues is set (has been assigned a value) and false otherwise */
  public boolean isSetEnumValues() {
    return this.enumValues != null;
  }

  public void setEnumValuesIsSet(boolean value) {
    if (!value) {
      this.enumValues = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case CLASS_NAME:
      if (value == null) {
        unsetClassName();
      } else {
        setClassName((java.lang.String)value);
      }
      break;

    case COMPONENT_CLASS_LIST:
      if (value == null) {
        unsetComponentClassList();
      } else {
        setComponentClassList((java.util.List<ClassInfo>)value);
      }
      break;

    case IMPLEMENT_CLASS_LIST:
      if (value == null) {
        unsetImplementClassList();
      } else {
        setImplementClassList((java.util.List<ClassInfo>)value);
      }
      break;

    case CONSTRUCTOR_LIST:
      if (value == null) {
        unsetConstructorList();
      } else {
        setConstructorList((java.util.List<ConstructorInfo>)value);
      }
      break;

    case ENUM_VALUES:
      if (value == null) {
        unsetEnumValues();
      } else {
        setEnumValues((java.util.List<java.lang.String>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CLASS_NAME:
      return getClassName();

    case COMPONENT_CLASS_LIST:
      return getComponentClassList();

    case IMPLEMENT_CLASS_LIST:
      return getImplementClassList();

    case CONSTRUCTOR_LIST:
      return getConstructorList();

    case ENUM_VALUES:
      return getEnumValues();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CLASS_NAME:
      return isSetClassName();
    case COMPONENT_CLASS_LIST:
      return isSetComponentClassList();
    case IMPLEMENT_CLASS_LIST:
      return isSetImplementClassList();
    case CONSTRUCTOR_LIST:
      return isSetConstructorList();
    case ENUM_VALUES:
      return isSetEnumValues();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ClassInfo)
      return this.equals((ClassInfo)that);
    return false;
  }

  public boolean equals(ClassInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_className = true && this.isSetClassName();
    boolean that_present_className = true && that.isSetClassName();
    if (this_present_className || that_present_className) {
      if (!(this_present_className && that_present_className))
        return false;
      if (!this.className.equals(that.className))
        return false;
    }

    boolean this_present_componentClassList = true && this.isSetComponentClassList();
    boolean that_present_componentClassList = true && that.isSetComponentClassList();
    if (this_present_componentClassList || that_present_componentClassList) {
      if (!(this_present_componentClassList && that_present_componentClassList))
        return false;
      if (!this.componentClassList.equals(that.componentClassList))
        return false;
    }

    boolean this_present_implementClassList = true && this.isSetImplementClassList();
    boolean that_present_implementClassList = true && that.isSetImplementClassList();
    if (this_present_implementClassList || that_present_implementClassList) {
      if (!(this_present_implementClassList && that_present_implementClassList))
        return false;
      if (!this.implementClassList.equals(that.implementClassList))
        return false;
    }

    boolean this_present_constructorList = true && this.isSetConstructorList();
    boolean that_present_constructorList = true && that.isSetConstructorList();
    if (this_present_constructorList || that_present_constructorList) {
      if (!(this_present_constructorList && that_present_constructorList))
        return false;
      if (!this.constructorList.equals(that.constructorList))
        return false;
    }

    boolean this_present_enumValues = true && this.isSetEnumValues();
    boolean that_present_enumValues = true && that.isSetEnumValues();
    if (this_present_enumValues || that_present_enumValues) {
      if (!(this_present_enumValues && that_present_enumValues))
        return false;
      if (!this.enumValues.equals(that.enumValues))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetClassName()) ? 131071 : 524287);
    if (isSetClassName())
      hashCode = hashCode * 8191 + className.hashCode();

    hashCode = hashCode * 8191 + ((isSetComponentClassList()) ? 131071 : 524287);
    if (isSetComponentClassList())
      hashCode = hashCode * 8191 + componentClassList.hashCode();

    hashCode = hashCode * 8191 + ((isSetImplementClassList()) ? 131071 : 524287);
    if (isSetImplementClassList())
      hashCode = hashCode * 8191 + implementClassList.hashCode();

    hashCode = hashCode * 8191 + ((isSetConstructorList()) ? 131071 : 524287);
    if (isSetConstructorList())
      hashCode = hashCode * 8191 + constructorList.hashCode();

    hashCode = hashCode * 8191 + ((isSetEnumValues()) ? 131071 : 524287);
    if (isSetEnumValues())
      hashCode = hashCode * 8191 + enumValues.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ClassInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetClassName()).compareTo(other.isSetClassName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClassName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.className, other.className);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetComponentClassList()).compareTo(other.isSetComponentClassList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComponentClassList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.componentClassList, other.componentClassList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetImplementClassList()).compareTo(other.isSetImplementClassList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImplementClassList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.implementClassList, other.implementClassList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetConstructorList()).compareTo(other.isSetConstructorList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConstructorList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.constructorList, other.constructorList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEnumValues()).compareTo(other.isSetEnumValues());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnumValues()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enumValues, other.enumValues);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ClassInfo(");
    boolean first = true;

    sb.append("className:");
    if (this.className == null) {
      sb.append("null");
    } else {
      sb.append(this.className);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("componentClassList:");
    if (this.componentClassList == null) {
      sb.append("null");
    } else {
      sb.append(this.componentClassList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("implementClassList:");
    if (this.implementClassList == null) {
      sb.append("null");
    } else {
      sb.append(this.implementClassList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("constructorList:");
    if (this.constructorList == null) {
      sb.append("null");
    } else {
      sb.append(this.constructorList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("enumValues:");
    if (this.enumValues == null) {
      sb.append("null");
    } else {
      sb.append(this.enumValues);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ClassInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ClassInfoStandardScheme getScheme() {
      return new ClassInfoStandardScheme();
    }
  }

  private static class ClassInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<ClassInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ClassInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLASS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.className = iprot.readString();
              struct.setClassNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPONENT_CLASS_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.componentClassList = new java.util.ArrayList<ClassInfo>(_list0.size);
                ClassInfo _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new ClassInfo();
                  _elem1.read(iprot);
                  struct.componentClassList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setComponentClassListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // IMPLEMENT_CLASS_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.implementClassList = new java.util.ArrayList<ClassInfo>(_list3.size);
                ClassInfo _elem4;
                for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                {
                  _elem4 = new ClassInfo();
                  _elem4.read(iprot);
                  struct.implementClassList.add(_elem4);
                }
                iprot.readListEnd();
              }
              struct.setImplementClassListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CONSTRUCTOR_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.constructorList = new java.util.ArrayList<ConstructorInfo>(_list6.size);
                ConstructorInfo _elem7;
                for (int _i8 = 0; _i8 < _list6.size; ++_i8)
                {
                  _elem7 = new ConstructorInfo();
                  _elem7.read(iprot);
                  struct.constructorList.add(_elem7);
                }
                iprot.readListEnd();
              }
              struct.setConstructorListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ENUM_VALUES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list9 = iprot.readListBegin();
                struct.enumValues = new java.util.ArrayList<java.lang.String>(_list9.size);
                java.lang.String _elem10;
                for (int _i11 = 0; _i11 < _list9.size; ++_i11)
                {
                  _elem10 = iprot.readString();
                  struct.enumValues.add(_elem10);
                }
                iprot.readListEnd();
              }
              struct.setEnumValuesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ClassInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.className != null) {
        oprot.writeFieldBegin(CLASS_NAME_FIELD_DESC);
        oprot.writeString(struct.className);
        oprot.writeFieldEnd();
      }
      if (struct.componentClassList != null) {
        oprot.writeFieldBegin(COMPONENT_CLASS_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.componentClassList.size()));
          for (ClassInfo _iter12 : struct.componentClassList)
          {
            _iter12.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.implementClassList != null) {
        oprot.writeFieldBegin(IMPLEMENT_CLASS_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.implementClassList.size()));
          for (ClassInfo _iter13 : struct.implementClassList)
          {
            _iter13.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.constructorList != null) {
        oprot.writeFieldBegin(CONSTRUCTOR_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.constructorList.size()));
          for (ConstructorInfo _iter14 : struct.constructorList)
          {
            _iter14.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.enumValues != null) {
        oprot.writeFieldBegin(ENUM_VALUES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.enumValues.size()));
          for (java.lang.String _iter15 : struct.enumValues)
          {
            oprot.writeString(_iter15);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ClassInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ClassInfoTupleScheme getScheme() {
      return new ClassInfoTupleScheme();
    }
  }

  private static class ClassInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<ClassInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ClassInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetClassName()) {
        optionals.set(0);
      }
      if (struct.isSetComponentClassList()) {
        optionals.set(1);
      }
      if (struct.isSetImplementClassList()) {
        optionals.set(2);
      }
      if (struct.isSetConstructorList()) {
        optionals.set(3);
      }
      if (struct.isSetEnumValues()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetClassName()) {
        oprot.writeString(struct.className);
      }
      if (struct.isSetComponentClassList()) {
        {
          oprot.writeI32(struct.componentClassList.size());
          for (ClassInfo _iter16 : struct.componentClassList)
          {
            _iter16.write(oprot);
          }
        }
      }
      if (struct.isSetImplementClassList()) {
        {
          oprot.writeI32(struct.implementClassList.size());
          for (ClassInfo _iter17 : struct.implementClassList)
          {
            _iter17.write(oprot);
          }
        }
      }
      if (struct.isSetConstructorList()) {
        {
          oprot.writeI32(struct.constructorList.size());
          for (ConstructorInfo _iter18 : struct.constructorList)
          {
            _iter18.write(oprot);
          }
        }
      }
      if (struct.isSetEnumValues()) {
        {
          oprot.writeI32(struct.enumValues.size());
          for (java.lang.String _iter19 : struct.enumValues)
          {
            oprot.writeString(_iter19);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ClassInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.className = iprot.readString();
        struct.setClassNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list20 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.componentClassList = new java.util.ArrayList<ClassInfo>(_list20.size);
          ClassInfo _elem21;
          for (int _i22 = 0; _i22 < _list20.size; ++_i22)
          {
            _elem21 = new ClassInfo();
            _elem21.read(iprot);
            struct.componentClassList.add(_elem21);
          }
        }
        struct.setComponentClassListIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list23 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.implementClassList = new java.util.ArrayList<ClassInfo>(_list23.size);
          ClassInfo _elem24;
          for (int _i25 = 0; _i25 < _list23.size; ++_i25)
          {
            _elem24 = new ClassInfo();
            _elem24.read(iprot);
            struct.implementClassList.add(_elem24);
          }
        }
        struct.setImplementClassListIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list26 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.constructorList = new java.util.ArrayList<ConstructorInfo>(_list26.size);
          ConstructorInfo _elem27;
          for (int _i28 = 0; _i28 < _list26.size; ++_i28)
          {
            _elem27 = new ConstructorInfo();
            _elem27.read(iprot);
            struct.constructorList.add(_elem27);
          }
        }
        struct.setConstructorListIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.enumValues = new java.util.ArrayList<java.lang.String>(_list29.size);
          java.lang.String _elem30;
          for (int _i31 = 0; _i31 < _list29.size; ++_i31)
          {
            _elem30 = iprot.readString();
            struct.enumValues.add(_elem30);
          }
        }
        struct.setEnumValuesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

